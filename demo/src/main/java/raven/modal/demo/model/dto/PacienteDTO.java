package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

import java.time.LocalDate;

@Getter
@Setter
public class PacienteDTO extends AbstractDTO {
    private String nome;
    private String nomesocial;

    private LocalDate datanascimento;

    private LocalDate datainicial;

    private LocalDate datafinal;
    private String cpf;
    private String rg;
    private boolean desativado;
    private boolean dicom;
    private String pacienteid;
}
