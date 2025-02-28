package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

import java.time.LocalDate;

@Getter
@Setter
public class FuncionarioCheckListDTO extends AbstractDTO {
    private String nomeUsuario;
    private Long codigoUsuario;

    private LocalDate dataCheckListInicio;

    private LocalDate dataCheckListFim;
}
