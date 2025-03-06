package raven.modal.demo.integracao;

import raven.modal.demo.model.Exame;
import raven.modal.demo.model.dto.ExameDTO;

import java.util.List;

public interface ExameIntegracao {
    Exame salvar(Exame exame);

    void deletar(Long codigo);

    Exame buscarId(Long codigo);

    List<Exame> listar();

    List<Exame> filtrando(ExameDTO filtro, String token);
}
