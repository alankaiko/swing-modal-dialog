package raven.modal.demo.repository.impl;

import org.apache.commons.lang3.StringUtils;
import raven.modal.demo.model.*;
import raven.modal.demo.model.dto.ProfissionalDTO;
import raven.modal.demo.repository.ProfissionalRepository;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class ProfissionalRepositoryImpl implements ProfissionalRepository {
    private EntityManager entityManager;

    public ProfissionalRepositoryImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        this.entityManager = emf.createEntityManager();
    }

    @Override
    public Profissional salvar(Profissional profissional) {
        EntityTransaction transaction = null;

        try {
            transaction = this.entityManager.getTransaction();
            transaction.begin();
            this.entityManager.persist(profissional);
            transaction.commit();
            return profissional;
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
            Profissional profissional = this.entityManager.find(Profissional.class, codigo);

            if (profissional != null) {
                this.entityManager.remove(profissional);
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
    public Profissional buscarId(Long codigo) {
        try {
            return this.entityManager.find(Profissional.class, codigo);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar a entidade", e);
        }
    }

    @Override
    public List<Profissional> listar() {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<Profissional> query = builder.createQuery(Profissional.class);
            query.from(Profissional.class);
            return this.entityManager.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar entidades", e);
        }
    }

    @Override
    public List<Profissional> filtrando(ProfissionalDTO filtro) {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<Profissional> query = builder.createQuery(Profissional.class);
            Root<Profissional> root = query.from(Profissional.class);

            Predicate[] predicates = this.adicionarRestricoes(builder, filtro, root);
            query.where(predicates);

            TypedQuery<Profissional> typedQuery = this.entityManager.createQuery(query);

            if (filtro.getItensPorPagina() != 0)
                typedQuery.setMaxResults(filtro.getItensPorPagina());

            if (filtro.getPagina() != 0)
                typedQuery.setFirstResult(filtro.getPagina());

            return typedQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao aplicar o filtro", e);
        }
    }

    private Predicate[] adicionarRestricoes(CriteriaBuilder builder, ProfissionalDTO filtro, Root<Profissional> root) {
        List<Predicate> lista = new ArrayList<>();

        Join<Profissional, TISSConselho> roottiss = root.join(Profissional_.conselho);
        Join<TISSConselho, Sigla> rootsigla = roottiss.join(TISSConselho_.sigla);

        if (!StringUtils.isEmpty(filtro.getNome()))
            lista.add(builder.like(builder.lower(root.get(Profissional_.nome)), "%" + filtro.getNome().toLowerCase() + "%"));

        if (filtro.getCodigoexaminador() != null)
            lista.add(builder.equal(root.get(Profissional_.codigoexaminador), filtro.getCodigoexaminador()));

        if (!StringUtils.isEmpty(filtro.getTissdescricao()))
            lista.add(builder.like(builder.lower(roottiss.get(TISSConselho_.descricao)), "%" + filtro.getTissdescricao().toLowerCase() + "%"));

        if (!StringUtils.isEmpty(filtro.getSigladescricao()))
            lista.add(builder.like(builder.lower(rootsigla.get(Sigla_.descricao)), "%" + filtro.getSigladescricao().toLowerCase() + "%"));

        if (!filtro.isDesativado())
            lista.add(builder.equal(root.get(Profissional_.desativado), filtro.isDesativado()));

        return lista.toArray(new Predicate[lista.size()]);
    }

}
