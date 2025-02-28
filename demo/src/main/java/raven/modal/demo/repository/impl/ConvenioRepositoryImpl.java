package raven.modal.demo.repository.impl;

import org.apache.commons.lang3.StringUtils;
import raven.modal.demo.model.Convenio;
import raven.modal.demo.model.Convenio_;
import raven.modal.demo.model.dto.ConvenioDTO;
import raven.modal.demo.repository.ConvenioRepository;
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

public class ConvenioRepositoryImpl implements ConvenioRepository {
    private EntityManager entityManager;

    public ConvenioRepositoryImpl() {
        this.entityManager = EntityManagerFactorySingleton.getEntityManager();
    }

    @Override
    public Convenio salvar(Convenio convenio) {
        EntityTransaction transaction = null;

        try {
            transaction = this.entityManager.getTransaction();
            transaction.begin();
            this.entityManager.persist(convenio);
            transaction.commit();
            return convenio;
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
            Convenio convenio = this.entityManager.find(Convenio.class, codigo);

            if (convenio != null) {
                this.entityManager.remove(convenio);
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
    public Convenio buscarId(Long codigo) {
        try {
            return this.entityManager.find(Convenio.class, codigo);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar a entidade", e);
        }
    }

    @Override
    public List<Convenio> listar() {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<Convenio> query = builder.createQuery(Convenio.class);
            query.from(Convenio.class);
            return this.entityManager.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar entidades", e);
        }
    }

    @Override
    public List<Convenio> filtrando(ConvenioDTO filtro) {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<Convenio> query = builder.createQuery(Convenio.class);
            Root<Convenio> root = query.from(Convenio.class);

            Predicate[] predicates = this.adicionarRestricoes(builder, filtro, root);
            query.where(predicates);

            TypedQuery<Convenio> typedQuery = this.entityManager.createQuery(query);

            if (filtro.getItensPorPagina() != 0)
                typedQuery.setMaxResults(filtro.getItensPorPagina());

            if (filtro.getPagina() != 0)
                typedQuery.setFirstResult(filtro.getPagina());

            return typedQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao aplicar o filtro", e);
        }
    }

    private Predicate[] adicionarRestricoes(CriteriaBuilder builder, ConvenioDTO filtro, Root<Convenio> root) {
        List<Predicate> lista = new ArrayList<>();

        if (!StringUtils.isEmpty(filtro.getNome()))
            lista.add(builder.like(builder.lower(root.get(Convenio_.NOME)), "%" + filtro.getNome().toLowerCase() + "%"));

        if (filtro.isAtivo())
            lista.add(builder.isTrue(root.get(Convenio_.ATIVO)));

        return lista.toArray(new Predicate[lista.size()]);
    }

}
