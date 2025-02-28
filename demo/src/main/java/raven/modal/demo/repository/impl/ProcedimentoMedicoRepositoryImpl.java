package raven.modal.demo.repository.impl;

import org.apache.commons.lang3.StringUtils;
import raven.modal.demo.model.ProcedimentoMedico;
import raven.modal.demo.model.ProcedimentoMedico_;
import raven.modal.demo.model.dto.ProcedimentoMedicoDTO;
import raven.modal.demo.repository.ProcedimentoMedicoRepository;
import raven.modal.demo.utils.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProcedimentoMedicoRepositoryImpl implements ProcedimentoMedicoRepository {
    private EntityManager entityManager;

    public ProcedimentoMedicoRepositoryImpl() {
        this.entityManager = EntityManagerFactorySingleton.getEntityManager();
    }

    @Override
    public ProcedimentoMedico salvar(ProcedimentoMedico procedimentoMedico) {
        EntityTransaction transaction = null;

        try {
            transaction = this.entityManager.getTransaction();
            transaction.begin();
            this.entityManager.persist(procedimentoMedico);
            transaction.commit();
            return procedimentoMedico;
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
            ProcedimentoMedico procedimentoMedico = this.entityManager.find(ProcedimentoMedico.class, codigo);

            if (procedimentoMedico != null) {
                this.entityManager.remove(procedimentoMedico);
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
    public ProcedimentoMedico buscarId(Long codigo) {
        try {
            return this.entityManager.find(ProcedimentoMedico.class, codigo);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar a entidade", e);
        }
    }

    @Override
    public List<ProcedimentoMedico> listar() {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<ProcedimentoMedico> query = builder.createQuery(ProcedimentoMedico.class);
            query.from(ProcedimentoMedico.class);
            return this.entityManager.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar entidades", e);
        }
    }

    @Override
    public List<ProcedimentoMedico> filtrando(ProcedimentoMedicoDTO filtro) {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<ProcedimentoMedico> query = builder.createQuery(ProcedimentoMedico.class);
            Root<ProcedimentoMedico> root = query.from(ProcedimentoMedico.class);

            Predicate[] predicates = this.adicionarRestricoes(builder, filtro, root);
            query.where(predicates);

            TypedQuery<ProcedimentoMedico> typedQuery = this.entityManager.createQuery(query);

            if (filtro.getItensPorPagina() != 0)
                typedQuery.setMaxResults(filtro.getItensPorPagina());

            if (filtro.getPagina() != 0)
                typedQuery.setFirstResult(filtro.getPagina());

            return typedQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao aplicar o filtro", e);
        }
    }

    private Predicate[] adicionarRestricoes(CriteriaBuilder builder, ProcedimentoMedicoDTO filtro, Root<ProcedimentoMedico> root) {
        List<Predicate> lista = new ArrayList<>();

        if (!StringUtils.isEmpty(filtro.getNome()))
            lista.add(builder.like(builder.lower(root.get(ProcedimentoMedico_.titulo)), "%" + filtro.getNome().toLowerCase() + "%"));

        return lista.toArray(new Predicate[lista.size()]);
    }

}
