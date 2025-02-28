package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;
import raven.modal.demo.model.enuns.EnumTipoSenhaAtendimento;

@Getter
@Setter
public class GerarSenhaDTO extends AbstractDTO {
    private Long tipoSenhaCodigo;
    private EnumTipoSenhaAtendimento tipoSenhaAtendimento;
}
