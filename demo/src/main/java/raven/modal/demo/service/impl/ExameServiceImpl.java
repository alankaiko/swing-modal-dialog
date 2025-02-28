package raven.modal.demo.service.impl;

import raven.modal.demo.model.Exame;
import raven.modal.demo.model.dto.ExameDTO;
import raven.modal.demo.repository.ExameRepository;
import raven.modal.demo.repository.impl.ExameRepositoryImpl;
import raven.modal.demo.service.ExameService;

import java.util.List;

public class ExameServiceImpl implements ExameService {
    private ExameRepository procedimentoMedicoRepository = new ExameRepositoryImpl();

    @Override
    public Exame salvar(Exame exame) {
        return this.procedimentoMedicoRepository.salvar(exame);
    }

    @Override
    public void deletar(Long codigo) {
        this.procedimentoMedicoRepository.deletar(codigo);
    }

    @Override
    public Exame buscarId(Long codigo) {
        return this.procedimentoMedicoRepository.buscarId(codigo);
    }

    @Override
    public List<Exame> listar() {
        return this.procedimentoMedicoRepository.listar();
    }

    @Override
    public List<Exame> filtrando(ExameDTO filter) {
        return this.procedimentoMedicoRepository.filtrando(filter);
    }
}
