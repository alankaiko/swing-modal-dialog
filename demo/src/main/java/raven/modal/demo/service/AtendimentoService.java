package raven.modal.demo.service;

import raven.modal.demo.model.Atendimento;
import raven.modal.demo.model.dto.AtendimentoDTO;

import java.util.List;

public interface AtendimentoService {
    Atendimento salvar(Atendimento atendimento);

    void deletar(Long codigo);

    Atendimento buscarId(Long codigo);

    List<Atendimento> listar();

    List<Atendimento> filtrando(AtendimentoDTO filter);
}
