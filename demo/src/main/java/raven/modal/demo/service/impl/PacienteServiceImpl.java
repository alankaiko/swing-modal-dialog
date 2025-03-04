package raven.modal.demo.service.impl;

import raven.modal.demo.model.Paciente;
import raven.modal.demo.model.dto.PacienteDTO;
import raven.modal.demo.repository.PacienteRepository;
import raven.modal.demo.repository.impl.PacienteRepositoryImpl;
import raven.modal.demo.service.PacienteService;

import java.util.List;

public class PacienteServiceImpl implements PacienteService {
    private PacienteRepository pacienteRepository = new PacienteRepositoryImpl();

    @Override
    public Paciente salvar(Paciente paciente) {
        return this.pacienteRepository.salvar(paciente);
    }

    @Override
    public void deletar(Long codigo) {
        this.pacienteRepository.deletar(codigo);
    }

    @Override
    public Paciente buscarId(Long codigo) {
        return this.pacienteRepository.buscarId(codigo);
    }

    @Override
    public List<Paciente> listar() {
        return this.pacienteRepository.listar();
    }

    @Override
    public List<Paciente> filtrando(PacienteDTO filter) {
        return this.pacienteRepository.filtrando(filter);
    }
}
