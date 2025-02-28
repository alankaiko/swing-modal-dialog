package raven.modal.demo.service.impl;

import raven.modal.demo.model.Sigla;
import raven.modal.demo.model.dto.SiglaDTO;
import raven.modal.demo.repository.SiglaRepository;
import raven.modal.demo.repository.impl.SiglaRepositoryImpl;
import raven.modal.demo.service.SiglaService;

import java.util.List;

public class SiglaServiceImpl implements SiglaService {
    private SiglaRepository siglaRepository = new SiglaRepositoryImpl();

    @Override
    public Sigla salvar(Sigla sigla) {
        return this.siglaRepository.salvar(sigla);
    }

    @Override
    public void deletar(Long codigo) {
        this.siglaRepository.deletar(codigo);
    }

    @Override
    public Sigla buscarId(Long codigo) {
        return this.siglaRepository.buscarId(codigo);
    }

    @Override
    public List<Sigla> listar() {
        return this.siglaRepository.listar();
    }

    @Override
    public List<Sigla> filtrando(SiglaDTO filter) {
        return this.siglaRepository.filtrando(filter);
    }
}
