package raven.modal.demo.repository;


import raven.modal.demo.model.Profissional;
import raven.modal.demo.model.dto.ProfissionalDTO;

import java.util.List;

public interface ProfissionalRepository {
    Profissional salvar(Profissional profissional);

    void deletar(Long codigo);

    Profissional buscarId(Long codigo);

    List<Profissional> listar();

    List<Profissional> filtrando(ProfissionalDTO filtro);
}
