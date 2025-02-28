package raven.modal.demo.service.impl;

import raven.modal.demo.model.Profissional;
import raven.modal.demo.model.dto.ProfissionalDTO;
import raven.modal.demo.repository.ProfissionalRepository;
import raven.modal.demo.repository.impl.ProfissionalRepositoryImpl;
import raven.modal.demo.service.ProfissionalService;

import java.util.List;

public class ProfissionalServiceImpl implements ProfissionalService {
    private ProfissionalRepository profissionalRepository = new ProfissionalRepositoryImpl();

    @Override
    public Profissional salvar(Profissional profissional) {
        return this.profissionalRepository.salvar(profissional);
    }

    @Override
    public void deletar(Long codigo) {
        this.profissionalRepository.deletar(codigo);
    }

    @Override
    public Profissional buscarId(Long codigo) {
        return this.profissionalRepository.buscarId(codigo);
    }

    @Override
    public List<Profissional> listar() {
        return this.profissionalRepository.listar();
    }

    @Override
    public List<Profissional> filtrando(ProfissionalDTO filter) {
        return this.profissionalRepository.filtrando(filter);
    }
}
