package raven.modal.demo.repository.impl;

import org.apache.commons.lang3.StringUtils;
import raven.modal.demo.model.Sigla;
import raven.modal.demo.model.Sigla_;
import raven.modal.demo.model.dto.SiglaDTO;
import raven.modal.demo.repository.SiglaRepository;
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

public class SiglaRepositoryImpl implements SiglaRepository {
    private EntityManager entityManager;

    public SiglaRepositoryImpl() {
        this.entityManager = EntityManagerFactorySingleton.getEntityManager();
    }

    @Override
    public Sigla salvar(Sigla sigla) {
        EntityTransaction transaction = null;

        try {
            transaction = this.entityManager.getTransaction();
            transaction.begin();
            this.entityManager.persist(sigla);
            transaction.commit();
            return sigla;
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
            Sigla sigla = this.entityManager.find(Sigla.class, codigo);

            if (sigla != null) {
                this.entityManager.remove(sigla);
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
    public Sigla buscarId(Long codigo) {
        try {
            return this.entityManager.find(Sigla.class, codigo);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar a entidade", e);
        }
    }

    @Override
    public List<Sigla> listar() {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<Sigla> query = builder.createQuery(Sigla.class);
            query.from(Sigla.class);
            return this.entityManager.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar entidades", e);
        }
    }

    @Override
    public List<Sigla> filtrando(SiglaDTO filtro) {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<Sigla> query = builder.createQuery(Sigla.class);
            Root<Sigla> root = query.from(Sigla.class);

            Predicate[] predicates = this.adicionarRestricoes(builder, filtro, root);
            query.where(predicates);

            TypedQuery<Sigla> typedQuery = this.entityManager.createQuery(query);

            if (filtro.getItensPorPagina() != 0)
                typedQuery.setMaxResults(filtro.getItensPorPagina());

            if (filtro.getPagina() != 0)
                typedQuery.setFirstResult(filtro.getPagina());

            return typedQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao aplicar o filtro", e);
        }
    }

    private Predicate[] adicionarRestricoes(CriteriaBuilder builder, SiglaDTO filtro, Root<Sigla> root) {
        List<Predicate> lista = new ArrayList<>();

        if (!StringUtils.isEmpty(filtro.getDescricao()))
            lista.add(builder.like(builder.lower(root.get(Sigla_.descricao)), "%" + filtro.getDescricao().toLowerCase() + "%"));

        return lista.toArray(new Predicate[lista.size()]);
    }

}
