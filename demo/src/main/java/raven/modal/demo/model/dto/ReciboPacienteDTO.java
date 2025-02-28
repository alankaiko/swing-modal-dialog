package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

@Getter
@Setter
public class ReciboPacienteDTO extends AbstractDTO {
    private String nomePaciente;
    private String nomeMedico;
    private int numero;
}
