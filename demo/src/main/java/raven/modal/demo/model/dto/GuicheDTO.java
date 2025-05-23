package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

import java.time.LocalDate;

@Getter
@Setter
public class GuicheDTO extends AbstractDTO {
    private String titulo;

    private LocalDate dataCadastro;

    private Long codigoUsuario;
}
