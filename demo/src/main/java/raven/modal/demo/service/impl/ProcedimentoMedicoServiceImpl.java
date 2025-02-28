package raven.modal.demo.service.impl;

import raven.modal.demo.model.ProcedimentoMedico;
import raven.modal.demo.model.dto.ProcedimentoMedicoDTO;
import raven.modal.demo.repository.ProcedimentoMedicoRepository;
import raven.modal.demo.repository.impl.ProcedimentoMedicoRepositoryImpl;
import raven.modal.demo.service.ProcedimentoMedicoService;

import java.util.List;

public class ProcedimentoMedicoServiceImpl implements ProcedimentoMedicoService {
    private ProcedimentoMedicoRepository procedimentoMedicoRepository = new ProcedimentoMedicoRepositoryImpl();

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
        return this.procedimentoMedicoRepository.filtrando(filter);
    }
}
