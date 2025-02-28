package raven.modal.demo.repository;

import raven.modal.demo.model.Paciente;
import raven.modal.demo.model.dto.PacienteDTO;

import java.util.List;

public interface PacienteRepository {
    Paciente salvar(Paciente paciente);

    void deletar(Long codigo);

    Paciente buscarId(Long codigo);

    List<Paciente> listar();

    List<Paciente> filtrando(PacienteDTO filtro);
}
