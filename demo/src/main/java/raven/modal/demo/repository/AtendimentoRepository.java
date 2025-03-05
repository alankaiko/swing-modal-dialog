package raven.modal.demo.repository;

import raven.modal.demo.model.Atendimento;
import raven.modal.demo.model.dto.AtendimentoDTO;
import raven.modal.demo.model.resumo.AtendimentoResumo;

import java.util.List;

public interface AtendimentoRepository {
    Atendimento salvar(Atendimento atendimento);

    void deletar(Long codigo);

    Atendimento buscarId(Long codigo);

    List<Atendimento> listar();

    List<AtendimentoResumo> filtrando(AtendimentoDTO filtro);
}
