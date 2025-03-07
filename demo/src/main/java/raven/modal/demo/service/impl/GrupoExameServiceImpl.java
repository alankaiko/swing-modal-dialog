package raven.modal.demo.service.impl;

import raven.modal.demo.integracao.GrupoExameIntegracao;
import raven.modal.demo.integracao.impl.GrupoExameIntegracaoImpl;
import raven.modal.demo.model.GrupoExame;
import raven.modal.demo.model.dto.GrupoExameDTO;
import raven.modal.demo.service.GrupoExameService;
import raven.modal.demo.utils.AuthToken;
import raven.modal.demo.utils.PageResponse;

import java.util.List;

public class GrupoExameServiceImpl implements GrupoExameService {
    private GrupoExameIntegracao grupoExameIntegracao = new GrupoExameIntegracaoImpl("application.properties", AuthToken.getToken());

    @Override
    public GrupoExame salvar(GrupoExame grupoExame) {
        return this.grupoExameIntegracao.salvar(grupoExame);
    }

    @Override
    public void deletar(Long codigo) {
        this.grupoExameIntegracao.deletar(codigo);
    }

    @Override
    public GrupoExame buscarId(Long codigo) {
        return this.grupoExameIntegracao.buscarId(codigo);
    }

    @Override
    public List<GrupoExame> listar() {
        return this.grupoExameIntegracao.listar();
    }

    @Override
    public PageResponse filtrando(GrupoExameDTO filter) {
        return this.grupoExameIntegracao.filtrando(filter);
    }
}
