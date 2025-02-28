package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

@Getter
@Setter
public class BancoDTO extends AbstractDTO {
    private String nome;
    private String numerobanco;
}
