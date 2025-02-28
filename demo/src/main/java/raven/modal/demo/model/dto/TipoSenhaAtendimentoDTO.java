package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

@Getter
@Setter
public class TipoSenhaAtendimentoDTO extends AbstractDTO {
    private String abreviacao;

    private String titulo;
}
