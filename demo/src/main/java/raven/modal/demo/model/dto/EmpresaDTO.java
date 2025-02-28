package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

@Getter
@Setter
public class EmpresaDTO extends AbstractDTO {
    private String titulo;
    private String razaosocial;
    private String nomefantasia;
    private String cnpj;
}
