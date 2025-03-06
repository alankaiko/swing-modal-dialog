package raven.modal.demo.service.impl;

import raven.modal.demo.integracao.ProcedimentoMedicoIntegracao;
import raven.modal.demo.integracao.impl.ProcedimentoMedicoIntegracaoImpl;
import raven.modal.demo.model.ProcedimentoMedico;
import raven.modal.demo.model.dto.ProcedimentoMedicoDTO;
import raven.modal.demo.service.ProcedimentoMedicoService;
import raven.modal.demo.utils.AuthToken;

import java.util.List;

public class ProcedimentoMedicoServiceImpl implements ProcedimentoMedicoService {
    private ProcedimentoMedicoIntegracao procedimentoMedicoRepository = new ProcedimentoMedicoIntegracaoImpl("application.properties");

    @Override
    public ProcedimentoMedico salvar(ProcedimentoMedico procedimentoMedico) {
        return this.procedimentoMedicoRepository.salvar(procedimentoMedico);
    }

    @Override
    public void deletar(Long codigo) {
        this.procedimentoMedicoRepository.deletar(codigo);
    }

    @Override
    public ProcedimentoMedico buscarId(Long codigo) {
        return this.procedimentoMedicoRepository.buscarId(codigo);
    }

    @Override
    public List<ProcedimentoMedico> listar() {
        return this.procedimentoMedicoRepository.listar();
    }

    @Override
    public List<ProcedimentoMedico> filtrando(ProcedimentoMedicoDTO filter) {
        return this.procedimentoMedicoRepository.filtrando(filter, AuthToken.getToken());
    }
}
