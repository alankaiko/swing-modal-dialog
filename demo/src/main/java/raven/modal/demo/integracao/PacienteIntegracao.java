package raven.modal.demo.integracao;

import raven.modal.demo.model.Paciente;
import raven.modal.demo.model.dto.PacienteDTO;
import raven.modal.demo.utils.PageResponse;

import java.util.List;

public interface PacienteIntegracao {
    Paciente salvar(Paciente paciente);

    void deletar(Long codigo);

    Paciente buscarId(Long codigo);

    List<Paciente> listar();

    PageResponse filtrando(PacienteDTO filtro);
}
