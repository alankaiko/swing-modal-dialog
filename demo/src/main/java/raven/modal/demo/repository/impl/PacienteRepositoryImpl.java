package raven.modal.demo.repository.impl;

import org.apache.commons.lang3.StringUtils;
import raven.modal.demo.model.Paciente;
import raven.modal.demo.model.Paciente_;
import raven.modal.demo.model.dto.PacienteDTO;
import raven.modal.demo.repository.PacienteRepository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PacienteRepositoryImpl implements PacienteRepository {
    private EntityManager entityManager;

    public PacienteRepositoryImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        this.entityManager = emf.createEntityManager();
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        EntityTransaction transaction = null;

        try {
            transaction = this.entityManager.getTransaction();
            transaction.begin();
            this.entityManager.persist(paciente);
            transaction.commit();
            return paciente;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao salvar a entidade", e);
        }
    }

    @Override
    public void deletar(Long codigo) {
        EntityTransaction transaction = null;

        try {
            transaction = this.entityManager.getTransaction();
            transaction.begin();
            Paciente entidade = this.entityManager.find(Paciente.class, codigo);

            if (entidade != null) {
                this.entityManager.remove(entidade);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao deletar a entidade", e);
        }
    }

    @Override
    public Paciente buscarId(Long codigo) {
        try {
            return this.entityManager.find(Paciente.class, codigo);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar a entidade", e);
        }
    }

    @Override
    public List<Paciente> listar() {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<Paciente> query = builder.createQuery(Paciente.class);
            query.from(Paciente.class);
            return this.entityManager.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar entidades", e);
        }
    }

    public List<Paciente> filtrando(PacienteDTO filtro) {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<Paciente> query = builder.createQuery(Paciente.class);
            Root<Paciente> root = query.from(Paciente.class);

            Predicate[] predicates = this.adicionarRestricoes(builder, filtro, root);
            query.where(predicates);

            TypedQuery<Paciente> typedQuery = this.entityManager.createQuery(query);

            if (filtro.getItensPorPagina() != 0)
                typedQuery.setMaxResults(filtro.getItensPorPagina());

            if (filtro.getPagina() != 0)
                typedQuery.setFirstResult(filtro.getPagina());

            return typedQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao aplicar o filtro", e);
        }
    }

    private Predicate[] adicionarRestricoes(CriteriaBuilder builder, PacienteDTO filtro, Root<Paciente> root) {
        List<Predicate> lista = new ArrayList<>();

        if (!StringUtils.isEmpty(filtro.getNome()))
            lista.add(builder.like(builder.lower(root.get(Paciente_.nome)), "%" + filtro.getNome().toLowerCase() + "%"));

        if (filtro.getDatanascimento() != null)
            lista.add(builder.equal(root.get(Paciente_.datanascimento), filtro.getDatanascimento()));

        if (filtro.getDatainicial() != null)
            lista.add(builder.greaterThanOrEqualTo(root.get(Paciente_.datacadastro), filtro.getDatainicial()));

        if (filtro.getDatafinal() != null)
            lista.add(builder.lessThanOrEqualTo(root.get(Paciente_.datacadastro), filtro.getDatafinal()));

        if (!StringUtils.isEmpty(filtro.getCpf()))
            lista.add(builder.like(builder.lower(root.get(Paciente_.cpf)), "%" + filtro.getCpf().toLowerCase() + "%"));

        if (!StringUtils.isEmpty(filtro.getRg()))
            lista.add(builder.like(builder.lower(root.get(Paciente_.rg)), "%" + filtro.getRg().toLowerCase() + "%"));

        if (!filtro.isDesativado())
            lista.add(builder.equal(root.get(Paciente_.desativado), filtro.isDesativado()));

        if (filtro.isDicom())
            lista.add(builder.equal(root.get(Paciente_.dicom), filtro.isDicom()));

        return lista.toArray(new Predicate[lista.size()]);
    }

}
