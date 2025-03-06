package raven.modal.demo.service.impl;

import raven.modal.demo.integracao.SiglaIntegracao;
import raven.modal.demo.integracao.impl.SiglaIntegracaoImpl;
import raven.modal.demo.model.Sigla;
import raven.modal.demo.model.dto.SiglaDTO;
import raven.modal.demo.service.SiglaService;
import raven.modal.demo.utils.AuthToken;

import java.util.List;

public class SiglaServiceImpl implements SiglaService {
    private SiglaIntegracao siglaIntegracao = new SiglaIntegracaoImpl("application.properties");

    @Override
    public Sigla salvar(Sigla sigla) {
        return this.siglaIntegracao.salvar(sigla);
    }

    @Override
    public void deletar(Long codigo) {
        this.siglaIntegracao.deletar(codigo);
    }

    @Override
    public Sigla buscarId(Long codigo) {
        return this.siglaIntegracao.buscarId(codigo);
    }

    @Override
    public List<Sigla> listar() {
        return this.siglaIntegracao.listar();
    }

    @Override
    public List<Sigla> filtrando(SiglaDTO filter) {
        return this.siglaIntegracao.filtrando(filter, AuthToken.getToken());
    }
}
