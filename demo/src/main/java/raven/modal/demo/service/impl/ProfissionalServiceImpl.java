package raven.modal.demo.service.impl;

import raven.modal.demo.integracao.ProfissionalIntegracao;
import raven.modal.demo.integracao.impl.ProfissionalIntegracaoImpl;
import raven.modal.demo.model.Profissional;
import raven.modal.demo.model.dto.ProfissionalDTO;
import raven.modal.demo.service.ProfissionalService;
import raven.modal.demo.utils.AuthToken;
import raven.modal.demo.utils.PageResponse;

import java.util.List;

public class ProfissionalServiceImpl implements ProfissionalService {
    private ProfissionalIntegracao profissionalIntegracao = new ProfissionalIntegracaoImpl("application.properties", AuthToken.getToken());

    @Override
    public Profissional salvar(Profissional profissional) {
        return this.profissionalIntegracao.salvar(profissional);
    }

    @Override
    public void deletar(Long codigo) {
        this.profissionalIntegracao.deletar(codigo);
    }

    @Override
    public Profissional buscarId(Long codigo) {
        return this.profissionalIntegracao.buscarId(codigo);
    }

    @Override
    public List<Profissional> listar() {
        return this.profissionalIntegracao.listar();
    }

    @Override
    public PageResponse filtrando(ProfissionalDTO filter) {
        return this.profissionalIntegracao.filtrando(filter);
    }
}
