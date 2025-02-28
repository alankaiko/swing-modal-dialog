package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

import java.time.LocalDate;

@Getter
@Setter
public class LembreteDTO extends AbstractDTO {
    private LocalDate dataregistro;

    private LocalDate dataaviso;
    private String nomePaciente;
    private String nomeMedico;
    private String nomeConvenio;

    private boolean confirmarcontato;

    private LocalDate dataconfirmacaocontato;

    private LocalDate dataavisoinicio;

    private LocalDate dataavisofim;
    private Long codigounidade;
    private Long codigousuario;
    private Long codigoprofissional;
    private boolean desativado;
}
