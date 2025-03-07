package raven.modal.demo.integracao;

import raven.modal.demo.model.Convenio;
import raven.modal.demo.model.dto.ConvenioDTO;
import raven.modal.demo.utils.PageResponse;

import java.util.List;

public interface ConvenioIntegracao {
    Convenio salvar(Convenio convenio);

    void deletar(Long codigo);

    Convenio buscarId(Long codigo);

    List<Convenio> listar();

    PageResponse filtrando(ConvenioDTO filtro, String token);
}
