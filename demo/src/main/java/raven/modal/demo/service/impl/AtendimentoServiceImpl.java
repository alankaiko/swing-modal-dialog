package raven.modal.demo.service.impl;

import raven.modal.demo.model.Atendimento;
import raven.modal.demo.model.dto.AtendimentoDTO;
import raven.modal.demo.model.resumo.AtendimentoResumo;
import raven.modal.demo.repository.AtendimentoRepository;
import raven.modal.demo.repository.impl.AtendimentoRepositoryImpl;
import raven.modal.demo.service.AtendimentoService;

import java.util.List;

public class AtendimentoServiceImpl implements AtendimentoService {
    private AtendimentoRepository atendimentoRepository = new AtendimentoRepositoryImpl();

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
    public List<AtendimentoResumo> filtrando(AtendimentoDTO filter) {
        return this.atendimentoRepository.filtrando(filter);
    }
}
