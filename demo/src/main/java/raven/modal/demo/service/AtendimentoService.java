package raven.modal.demo.service;

import raven.modal.demo.model.Atendimento;
import raven.modal.demo.model.dto.AtendimentoDTO;
import raven.modal.demo.utils.PageResponse;

import java.util.List;

public interface AtendimentoService {
    Atendimento salvar(Atendimento atendimento);

    void deletar(Long codigo);

    Atendimento buscarId(Long codigo);

    List<Atendimento> listar();

    PageResponse filtrando(AtendimentoDTO filter);
}
