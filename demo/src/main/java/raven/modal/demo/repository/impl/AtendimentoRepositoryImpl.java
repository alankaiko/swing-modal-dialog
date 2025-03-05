package raven.modal.demo.repository.impl;

import org.apache.commons.lang3.StringUtils;
import raven.modal.demo.model.*;
import raven.modal.demo.model.dto.AtendimentoDTO;
import raven.modal.demo.model.enuns.EnumTipoAtendimento;
import raven.modal.demo.model.resumo.AtendimentoResumo;
import raven.modal.demo.repository.AtendimentoRepository;
import raven.modal.demo.utils.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoRepositoryImpl implements AtendimentoRepository {
    private EntityManager entityManager;

    public AtendimentoRepositoryImpl() {
        this.entityManager = EntityManagerFactorySingleton.getEntityManager();
    }

    @Override
    public Atendimento salvar(Atendimento atendimento) {
        EntityTransaction transaction = null;

        try {
            transaction = this.entityManager.getTransaction();
            transaction.begin();
            this.entityManager.persist(atendimento);
            transaction.commit();
            return atendimento;
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
            Atendimento entidade = this.entityManager.find(Atendimento.class, codigo);

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
    public Atendimento buscarId(Long codigo) {
        try {
            return this.entityManager.find(Atendimento.class, codigo);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar a entidade", e);
        }
    }

    @Override
    public List<Atendimento> listar() {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<Atendimento> query = builder.createQuery(Atendimento.class);
            query.from(Atendimento.class);
            return this.entityManager.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar entidades", e);
        }
    }

    @Override
    public List<AtendimentoResumo> filtrando(AtendimentoDTO filtro) {
        try {
            CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
            CriteriaQuery<AtendimentoResumo> query = builder.createQuery(AtendimentoResumo.class);
            Root<Atendimento> root = query.from(Atendimento.class);
            Join<Atendimento, Paciente> atendimentoPacienteJoin = root.join(Atendimento_.PACIENTE);
            Join<Atendimento, Profissional> atendimentoProfissionalJoin = root.join(Atendimento_.MEDICO);
            Join<Atendimento, UnidadeComp> atendimentoUnidadeCompJoin = root.join(Atendimento_.UNIDADE);

            query.select(builder.construct(
                    AtendimentoResumo.class,
                    root.get(Atendimento_.CODIGO),
                    root.get(Atendimento_.DATAATENDIMENTO),
                    root.get(Atendimento_.TIPODOATENDIMENTO),
                    root.get(Atendimento_.STATUSAGENDAMENTO),
                    atendimentoPacienteJoin.get(Paciente_.NOME),
                    atendimentoProfissionalJoin.get(Profissional_.NOME),
                    atendimentoUnidadeCompJoin.get(UnidadeComp_.NOMEUNIDADE)
            ));

            Predicate[] predicates = this.adicionarRestricoes(builder, filtro, root);
            query.where(predicates);

            TypedQuery<AtendimentoResumo> typedQuery = this.entityManager.createQuery(query);

            if (filtro.getItensPorPagina() != 0)
                typedQuery.setMaxResults(filtro.getItensPorPagina());

            if (filtro.getPagina() != 0)
                typedQuery.setFirstResult(filtro.getPagina());

            return typedQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao aplicar o filtro", e);
        }
    }


    private Predicate[] adicionarRestricoes(CriteriaBuilder builder, AtendimentoDTO filtro, Root<Atendimento> root) {
        List<Predicate> lista = new ArrayList<>();

        if (filtro.getDataatendimento() != null)
            lista.add(builder.equal(root.get(Atendimento_.dataatendimento), filtro.getDataatendimento()));

        if (filtro.getCodigoRegistro() != null)
            lista.add(builder.equal(root.get(Atendimento_.CODIGO), filtro.getCodigoRegistro()));

        if (filtro.getDataInicialRangeInicio() != null)
            lista.add(builder.greaterThanOrEqualTo(root.get(Atendimento_.datainicio), filtro.getDataInicialRangeInicio()));

        if (filtro.getDataInicialRangeFim() != null)
            lista.add(builder.lessThanOrEqualTo(root.get(Atendimento_.datainicio), filtro.getDataInicialRangeFim()));

        if (filtro.getCodigoDepartamento() != null)
            lista.add(builder.equal(root.get(Atendimento_.departamento), filtro.getCodigoDepartamento()));

        if (filtro.getCodigoProfissional() != null)
            lista.add(builder.equal(root.get(Atendimento_.MEDICO), filtro.getCodigoProfissional()));

        if (!StringUtils.isEmpty(filtro.getNomePaciente())) {
            Join<Atendimento, Paciente> rootpaciente = root.join(Atendimento_.paciente);
            lista.add(builder.like(builder.lower(rootpaciente.get(Paciente_.nome)), "%" + filtro.getNomePaciente().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(filtro.getNomeMedico())) {
            Join<Atendimento, Profissional> rootprofissional = root.join(Atendimento_.medico);
            lista.add(builder.like(builder.lower(rootprofissional.get(Profissional_.nome)), "%" + filtro.getNomeMedico().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(filtro.getNomeUnidade())) {
            Join<Atendimento, UnidadeComp> rootunidade = root.join(Atendimento_.unidade);
            lista.add(builder.like(builder.lower(rootunidade.get(UnidadeComp_.nomeunidade)), "%" + filtro.getNomeUnidade().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(filtro.getNomeDepartamento())) {
            Join<Atendimento, Departamento> rootdepartamento = root.join(Atendimento_.departamento);
            lista.add(builder.like(builder.lower(rootdepartamento.get(Departamento_.nome)), "%" + filtro.getNomeDepartamento().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(filtro.getNomeProcedimento())) {
            ListJoin<Atendimento, ProcedimentoAtendimento> atendimentoProcedimentoAtendimentoListJoin = root.joinList(Atendimento_.PROCEDIMENTOS);
            Join<ProcedimentoAtendimento, ProcedimentoMedico> procedimentoMedicoJoin = atendimentoProcedimentoAtendimentoListJoin.join(ProcedimentoAtendimento_.PROCEDIMENTOMEDICO);
            lista.add(builder.equal(builder.lower(procedimentoMedicoJoin.get(ProcedimentoMedico_.titulo)), filtro.getNomeProcedimento()));
        }

        //filtro obrigatorio
        if (filtro.getCodigoUnidade() != null)
            lista.add(builder.equal(root.get(Atendimento_.unidade), filtro.getCodigoUnidade()));

        //filtro para a tela de atendimento onde nao mostra a agenda particular do medico
        if (filtro.getTelaAtendimento() != null && filtro.getTelaAtendimento()) {
            lista.add(builder.or(
                            builder.notEqual(root.get(Atendimento_.TIPODOATENDIMENTO), EnumTipoAtendimento.PARTICULAR),
                            builder.isNull(root.get(Atendimento_.TIPODOATENDIMENTO))
                    )
            );
        }

        return lista.toArray(new Predicate[lista.size()]);
    }

}
