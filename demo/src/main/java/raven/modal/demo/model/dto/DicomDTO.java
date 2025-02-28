package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

import java.time.LocalDate;

@Getter
@Setter
public class DicomDTO extends AbstractDTO {
    private String nomePaciente;

    private LocalDate dataInicial;

    private LocalDate dataFinal;
}

