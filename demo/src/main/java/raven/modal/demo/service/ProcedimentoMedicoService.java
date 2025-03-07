package raven.modal.demo.service;

import raven.modal.demo.model.ProcedimentoMedico;
import raven.modal.demo.model.dto.ProcedimentoMedicoDTO;
import raven.modal.demo.utils.PageResponse;

import java.util.List;

public interface ProcedimentoMedicoService {
    ProcedimentoMedico salvar(ProcedimentoMedico procedimentoMedico);

    void deletar(Long codigo);

    ProcedimentoMedico buscarId(Long codigo);

    List<ProcedimentoMedico> listar();

    PageResponse filtrando(ProcedimentoMedicoDTO filter);
}
