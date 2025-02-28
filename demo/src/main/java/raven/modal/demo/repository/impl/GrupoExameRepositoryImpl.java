package raven.modal.demo.repository.impl;

import org.apache.commons.lang3.StringUtils;
import raven.modal.demo.model.GrupoExame;
import raven.modal.demo.model.GrupoExame_;
import raven.modal.demo.model.dto.GrupoExameDTO;
import raven.modal.demo.repository.GrupoExameRepository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class GrupoExameRepositoryImpl implements GrupoExameRepository {
    private EntityManager entityManager;

    public GrupoExameRepositoryImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        this.entityManager = emf.createEntityManager();
    }

    @Override
    public GrupoExame salvar(GrupoExame grupoExame) {
        EntityTransaction transaction = null;

        try {
            transaction = this.entityManager.getTransaction();
            transaction.begin();
            this.entityManager.persist(grupoExame);
            transaction.commit();
            return grupoExame;
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
            GrupoExame grupoExame = this.entityManager.find(GrupoExame.class, codigo);

            if (grupoExame != null) {
                this.entityManager.remove(grupoExame);
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
    public GrupoExame buscarId(Long codigo) {
        try {
            return this.entityManager.find(GrupoExame.class, codigo);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar a entidade", e);
        }
    }

    @Override
    public List<GrupoExame> listar() {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<GrupoExame> query = builder.createQuery(GrupoExame.class);
            query.from(GrupoExame.class);
            return this.entityManager.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar entidades", e);
        }
    }

    @Override
    public List<GrupoExame> filtrando(GrupoExameDTO filtro) {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<GrupoExame> query = builder.createQuery(GrupoExame.class);
            Root<GrupoExame> root = query.from(GrupoExame.class);

            Predicate[] predicates = this.adicionarRestricoes(builder, filtro, root);
            query.where(predicates);

            TypedQuery<GrupoExame> typedQuery = this.entityManager.createQuery(query);

            if (filtro.getItensPorPagina() != 0)
                typedQuery.setMaxResults(filtro.getItensPorPagina());

            if (filtro.getPagina() != 0)
                typedQuery.setFirstResult(filtro.getPagina());

            return typedQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao aplicar o filtro", e);
        }
    }

    private Predicate[] adicionarRestricoes(CriteriaBuilder builder, GrupoExameDTO filtro, Root<GrupoExame> root) {
        List<Predicate> lista = new ArrayList<>();

        if (!StringUtils.isEmpty(filtro.getTitulo()))
            lista.add(builder.like(builder.lower(root.get(GrupoExame_.titulo)), "%" + filtro.getTitulo().toLowerCase() + "%"));

        return lista.toArray(new Predicate[lista.size()]);
    }

}
