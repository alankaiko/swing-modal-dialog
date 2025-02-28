package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

@Getter
@Setter
public class ConvenioDTO extends AbstractDTO {
    private String nome;
    private boolean ativo;
}
