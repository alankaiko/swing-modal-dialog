package raven.modal.demo.service.impl;

import raven.modal.demo.integracao.ConvenioIntegracao;
import raven.modal.demo.integracao.impl.ConvenioIntegracaoImpl;
import raven.modal.demo.model.Convenio;
import raven.modal.demo.model.dto.ConvenioDTO;
import raven.modal.demo.service.ConvenioService;
import raven.modal.demo.utils.AuthToken;

import java.util.List;

public class ConvenioServiceImpl implements ConvenioService {
    private ConvenioIntegracao convenioIntegracao = new ConvenioIntegracaoImpl("application.properties");

    @Override
    public Convenio salvar(Convenio convenio) {
        return this.convenioIntegracao.salvar(convenio);
    }

    @Override
    public void deletar(Long codigo) {
        this.convenioIntegracao.deletar(codigo);
    }

    @Override
    public Convenio buscarId(Long codigo) {
        return this.convenioIntegracao.buscarId(codigo);
    }

    @Override
    public List<Convenio> listar() {
        return this.convenioIntegracao.listar();
    }

    @Override
    public List<Convenio> filtrando(ConvenioDTO filter) {
        return this.convenioIntegracao.filtrando(filter, AuthToken.getToken());
    }
}
