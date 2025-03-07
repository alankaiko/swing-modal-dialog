package raven.modal.demo.integracao;

import raven.modal.demo.model.Paciente;
import raven.modal.demo.model.dto.PacienteDTO;

import java.util.List;

public interface PacienteIntegracao {
    Paciente salvar(Paciente paciente);

    void deletar(Long codigo);

    Paciente buscarId(Long codigo);

    List<Paciente> listar();

    List<Paciente> filtrando(PacienteDTO filtro, String token);
}
