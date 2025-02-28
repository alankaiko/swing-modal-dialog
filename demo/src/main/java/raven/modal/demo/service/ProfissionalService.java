package raven.modal.demo.service;

import raven.modal.demo.model.Profissional;
import raven.modal.demo.model.dto.ProfissionalDTO;

import java.util.List;

public interface ProfissionalService {
    Profissional salvar(Profissional profissional);

    void deletar(Long codigo);

    Profissional buscarId(Long codigo);

    List<Profissional> listar();

    List<Profissional> filtrando(ProfissionalDTO filter);
}
