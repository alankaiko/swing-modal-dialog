package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

@Getter
@Setter
public class ExamesAgrupadoDTO extends AbstractDTO {
    private String nomeMedico;
    private String titulo;
    private String descricao;
}
