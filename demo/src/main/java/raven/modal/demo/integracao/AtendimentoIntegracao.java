package raven.modal.demo.integracao;

import raven.modal.demo.model.Atendimento;
import raven.modal.demo.model.dto.AtendimentoDTO;
import raven.modal.demo.model.resumo.AtendimentoResumo;

import java.util.List;

public interface AtendimentoIntegracao {
    Atendimento salvar(Atendimento atendimento);

    void deletar(Long codigo);

    Atendimento buscarId(Long codigo);

    List<Atendimento> listar();

    List<AtendimentoResumo> filtrando(AtendimentoDTO filtro, String token);
}
