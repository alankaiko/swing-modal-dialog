package raven.modal.demo.integracao;

import raven.modal.demo.model.GrupoExame;
import raven.modal.demo.model.dto.GrupoExameDTO;
import raven.modal.demo.utils.PageResponse;

import java.util.List;

public interface GrupoExameIntegracao {
    GrupoExame salvar(GrupoExame grupoExame);

    void deletar(Long codigo);

    GrupoExame buscarId(Long codigo);

    List<GrupoExame> listar();

    PageResponse filtrando(GrupoExameDTO filtro);
}
