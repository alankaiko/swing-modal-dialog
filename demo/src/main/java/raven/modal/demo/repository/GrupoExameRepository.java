package raven.modal.demo.repository;


import raven.modal.demo.model.GrupoExame;
import raven.modal.demo.model.dto.GrupoExameDTO;

import java.util.List;

public interface GrupoExameRepository {
    GrupoExame salvar(GrupoExame grupoExame);

    void deletar(Long codigo);

    GrupoExame buscarId(Long codigo);

    List<GrupoExame> listar();

    List<GrupoExame> filtrando(GrupoExameDTO filtro);
}
