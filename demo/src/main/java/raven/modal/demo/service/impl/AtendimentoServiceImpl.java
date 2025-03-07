package raven.modal.demo.service.impl;

import raven.modal.demo.integracao.AtendimentoIntegracao;
import raven.modal.demo.integracao.impl.AtendimentoIntegracaoImpl;
import raven.modal.demo.model.Atendimento;
import raven.modal.demo.model.dto.AtendimentoDTO;
import raven.modal.demo.service.AtendimentoService;
import raven.modal.demo.utils.AuthToken;
import raven.modal.demo.utils.PageResponse;

import java.util.List;

public class AtendimentoServiceImpl implements AtendimentoService {
    private AtendimentoIntegracao atendimentoRepository = new AtendimentoIntegracaoImpl("application.properties", AuthToken.getToken());

    @Override
    public Atendimento salvar(Atendimento atendimento) {
        return this.atendimentoRepository.salvar(atendimento);
    }

    @Override
    public void deletar(Long codigo) {
        this.atendimentoRepository.deletar(codigo);
    }

    @Override
    public Atendimento buscarId(Long codigo) {
        return this.atendimentoRepository.buscarId(codigo);
    }

    @Override
    public List<Atendimento> listar() {
        return this.atendimentoRepository.listar();
    }

    @Override
    public PageResponse filtrando(AtendimentoDTO filter) {
        return this.atendimentoRepository.filtrando(filter);
    }
}
