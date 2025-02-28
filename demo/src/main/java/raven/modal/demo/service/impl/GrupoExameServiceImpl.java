package raven.modal.demo.service.impl;

import raven.modal.demo.model.GrupoExame;
import raven.modal.demo.model.dto.GrupoExameDTO;
import raven.modal.demo.repository.GrupoExameRepository;
import raven.modal.demo.repository.impl.GrupoExameRepositoryImpl;
import raven.modal.demo.service.GrupoExameService;

import java.util.List;

public class GrupoExameServiceImpl implements GrupoExameService {
    private GrupoExameRepository grupoExameRepository = new GrupoExameRepositoryImpl();

    @Override
    public GrupoExame salvar(GrupoExame grupoExame) {
        return this.grupoExameRepository.salvar(grupoExame);
    }

    @Override
    public void deletar(Long codigo) {
        this.grupoExameRepository.deletar(codigo);
    }

    @Override
    public GrupoExame buscarId(Long codigo) {
        return this.grupoExameRepository.buscarId(codigo);
    }

    @Override
    public List<GrupoExame> listar() {
        return this.grupoExameRepository.listar();
    }

    @Override
    public List<GrupoExame> filtrando(GrupoExameDTO filter) {
        return this.grupoExameRepository.filtrando(filter);
    }
}
