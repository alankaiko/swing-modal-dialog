package raven.modal.demo.repository;

import raven.modal.demo.model.Sigla;
import raven.modal.demo.model.dto.SiglaDTO;

import java.util.List;

public interface SiglaRepository {
    Sigla salvar(Sigla sigla);

    void deletar(Long codigo);

    Sigla buscarId(Long codigo);

    List<Sigla> listar();

    List<Sigla> filtrando(SiglaDTO filtro);
}
