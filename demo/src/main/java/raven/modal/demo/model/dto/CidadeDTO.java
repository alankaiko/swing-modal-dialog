package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

@Getter
@Setter
public class CidadeDTO extends AbstractDTO {
    private String abrevEstado;

    private String estado;

    private String cidade;
}
