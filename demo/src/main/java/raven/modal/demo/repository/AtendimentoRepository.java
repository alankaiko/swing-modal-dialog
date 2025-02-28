package raven.modal.demo.repository;

import raven.modal.demo.model.Atendimento;
import raven.modal.demo.model.dto.AtendimentoDTO;

import java.util.List;

public interface AtendimentoRepository {
    Atendimento salvar(Atendimento atendimento);

    void deletar(Long codigo);

    Atendimento buscarId(Long codigo);

    List<Atendimento> listar();

    List<Atendimento> filtrando(AtendimentoDTO filtro);
}
