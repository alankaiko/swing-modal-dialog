package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

import java.time.LocalDate;

@Getter
@Setter
public class LembreteAgendaDTO extends AbstractDTO {
    private LocalDate dataAviso;

    private String nomePaciente;

    private LocalDate dataConfirmacaoContato;

    private Boolean contatoEfetuado;
}
