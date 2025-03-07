package raven.modal.demo.service;

import raven.modal.demo.model.Exame;
import raven.modal.demo.model.dto.ExameDTO;
import raven.modal.demo.utils.PageResponse;

import java.util.List;

public interface ExameService {
    Exame salvar(Exame exame);

    void deletar(Long codigo);

    Exame buscarId(Long codigo);

    List<Exame> listar();

    PageResponse filtrando(ExameDTO filter);
}
