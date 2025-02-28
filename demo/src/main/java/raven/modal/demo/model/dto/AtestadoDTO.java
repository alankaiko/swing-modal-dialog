package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

import java.time.LocalDate;

@Getter
@Setter
public class AtestadoDTO extends AbstractDTO {
    private LocalDate dataimpressao;
    private boolean imprimido;

    private LocalDate dataatendimento;
    private String nomepaciente;
    private String acompanhante;
}
