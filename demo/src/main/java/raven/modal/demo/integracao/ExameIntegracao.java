package raven.modal.demo.integracao;

import raven.modal.demo.model.Exame;
import raven.modal.demo.model.dto.ExameDTO;
import raven.modal.demo.utils.PageResponse;

import java.util.List;

public interface ExameIntegracao {
    Exame salvar(Exame exame);

    void deletar(Long codigo);

    Exame buscarId(Long codigo);

    List<Exame> listar();

    PageResponse filtrando(ExameDTO filtro);
}
