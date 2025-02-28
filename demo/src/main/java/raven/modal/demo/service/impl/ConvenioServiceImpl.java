package raven.modal.demo.service.impl;

import raven.modal.demo.model.Convenio;
import raven.modal.demo.model.dto.ConvenioDTO;
import raven.modal.demo.repository.ConvenioRepository;
import raven.modal.demo.repository.impl.ConvenioRepositoryImpl;
import raven.modal.demo.service.ConvenioService;

import java.util.List;

public class ConvenioServiceImpl implements ConvenioService {
    private ConvenioRepository convenioRepository = new ConvenioRepositoryImpl();

    @Override
    public Convenio salvar(Convenio convenio) {
        return this.convenioRepository.salvar(convenio);
    }

    @Override
    public void deletar(Long codigo) {
        this.convenioRepository.deletar(codigo);
    }

    @Override
    public Convenio buscarId(Long codigo) {
        return this.convenioRepository.buscarId(codigo);
    }

    @Override
    public List<Convenio> listar() {
        return this.convenioRepository.listar();
    }

    @Override
    public List<Convenio> filtrando(ConvenioDTO filter) {
        return this.convenioRepository.filtrando(filter);
    }
}
