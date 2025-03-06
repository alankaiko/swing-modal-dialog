package raven.modal.demo.integracao;

import raven.modal.demo.model.Sigla;
import raven.modal.demo.model.dto.SiglaDTO;

import java.util.List;

public interface SiglaIntegracao {
    Sigla salvar(Sigla sigla);

    void deletar(Long codigo);

    Sigla buscarId(Long codigo);

    List<Sigla> listar();

    List<Sigla> filtrando(SiglaDTO filtro, String token);
}
