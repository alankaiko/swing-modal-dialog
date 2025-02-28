package raven.modal.demo.service;

import raven.modal.demo.model.Convenio;
import raven.modal.demo.model.dto.ConvenioDTO;

import java.util.List;

public interface ConvenioService {
    Convenio salvar(Convenio convenio);

    void deletar(Long codigo);

    Convenio buscarId(Long codigo);

    List<Convenio> listar();

    List<Convenio> filtrando(ConvenioDTO filtro);
}
