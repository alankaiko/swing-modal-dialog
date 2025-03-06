package raven.modal.demo.service.impl;

import raven.modal.demo.integracao.ExameIntegracao;
import raven.modal.demo.integracao.impl.ExameIntegracaoImpl;
import raven.modal.demo.model.Exame;
import raven.modal.demo.model.dto.ExameDTO;
import raven.modal.demo.service.ExameService;
import raven.modal.demo.utils.AuthToken;

import java.util.List;

public class ExameServiceImpl implements ExameService {
    private ExameIntegracao exameIntegracao = new ExameIntegracaoImpl("application.properties");

    @Override
    public Exame salvar(Exame exame) {
        return this.exameIntegracao.salvar(exame);
    }

    @Override
    public void deletar(Long codigo) {
        this.exameIntegracao.deletar(codigo);
    }

    @Override
    public Exame buscarId(Long codigo) {
        return this.exameIntegracao.buscarId(codigo);
    }

    @Override
    public List<Exame> listar() {
        return this.exameIntegracao.listar();
    }

    @Override
    public List<Exame> filtrando(ExameDTO filter) {
        return this.exameIntegracao.filtrando(filter, AuthToken.getToken());
    }
}
