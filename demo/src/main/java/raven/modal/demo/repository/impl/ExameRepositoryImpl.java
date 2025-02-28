package raven.modal.demo.repository.impl;

import org.apache.commons.lang3.StringUtils;
import raven.modal.demo.model.Exame;
import raven.modal.demo.model.Exame_;
import raven.modal.demo.model.GrupoExame;
import raven.modal.demo.model.GrupoExame_;
import raven.modal.demo.model.dto.ExameDTO;
import raven.modal.demo.repository.ExameRepository;
import raven.modal.demo.utils.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class ExameRepositoryImpl implements ExameRepository {
    private EntityManager entityManager;

    public ExameRepositoryImpl() {
        this.entityManager = EntityManagerFactorySingleton.getEntityManager();
    }

    @Override
    public Exame salvar(Exame exame) {
        EntityTransaction transaction = null;

        try {
            transaction = this.entityManager.getTransaction();
            transaction.begin();
            this.entityManager.persist(exame);
            transaction.commit();
            return exame;
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
            Exame exame = this.entityManager.find(Exame.class, codigo);

            if (exame != null) {
                this.entityManager.remove(exame);
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
    public Exame buscarId(Long codigo) {
        try {
            return this.entityManager.find(Exame.class, codigo);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar a entidade", e);
        }
    }

    @Override
    public List<Exame> listar() {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<Exame> query = builder.createQuery(Exame.class);
            query.from(Exame.class);
            return this.entityManager.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar entidades", e);
        }
    }

    @Override
    public List<Exame> filtrando(ExameDTO filtro) {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<Exame> query = builder.createQuery(Exame.class);
            Root<Exame> root = query.from(Exame.class);

            Predicate[] predicates = this.adicionarRestricoes(builder, filtro, root);
            query.where(predicates);

            TypedQuery<Exame> typedQuery = this.entityManager.createQuery(query);

            if (filtro.getItensPorPagina() != 0)
                typedQuery.setMaxResults(filtro.getItensPorPagina());

            if (filtro.getPagina() != 0)
                typedQuery.setFirstResult(filtro.getPagina());

            return typedQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao aplicar o filtro", e);
        }
    }

    private Predicate[] adicionarRestricoes(CriteriaBuilder builder, ExameDTO filtro, Root<Exame> root) {
        List<Predicate> lista = new ArrayList<>();

        Join<Exame, GrupoExame> rootgrupo = root.join(Exame_.grupoexame);

        if (!StringUtils.isEmpty(filtro.getTitulo()))
            lista.add(builder.like(builder.lower(root.get(Exame_.titulo)), "%" + filtro.getTitulo().toLowerCase() + "%"));

        if (!StringUtils.isEmpty(filtro.getCodigoabrev()))
            lista.add(builder.like(builder.lower(root.get(Exame_.codigoabrev)), "%" + filtro.getCodigoabrev().toLowerCase() + "%"));

        if (!StringUtils.isEmpty(filtro.getTituloGrupo()))
            lista.add(builder.like(builder.lower(rootgrupo.get(GrupoExame_.titulo)), "%" + filtro.getTituloGrupo().toLowerCase() + "%"));

        return lista.toArray(new Predicate[lista.size()]);
    }

}
