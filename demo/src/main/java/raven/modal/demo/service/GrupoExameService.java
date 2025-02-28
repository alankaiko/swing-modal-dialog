package raven.modal.demo.service;

import raven.modal.demo.model.GrupoExame;
import raven.modal.demo.model.dto.GrupoExameDTO;

import java.util.List;

public interface GrupoExameService {
    GrupoExame salvar(GrupoExame grupoExame);

    void deletar(Long codigo);

    GrupoExame buscarId(Long codigo);

    List<GrupoExame> listar();

    List<GrupoExame> filtrando(GrupoExameDTO filtro);
}
