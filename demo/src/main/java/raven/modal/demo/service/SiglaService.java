package raven.modal.demo.service;

import raven.modal.demo.model.Sigla;
import raven.modal.demo.model.dto.SiglaDTO;
import raven.modal.demo.utils.PageResponse;

import java.util.List;

public interface SiglaService {
    Sigla salvar(Sigla sigla);

    void deletar(Long codigo);

    Sigla buscarId(Long codigo);

    List<Sigla> listar();

    PageResponse filtrando(SiglaDTO filtro);
}
