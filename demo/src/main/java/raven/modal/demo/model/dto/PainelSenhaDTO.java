package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;
import raven.modal.demo.model.enuns.EnumSenhaPainel;
import raven.modal.demo.model.enuns.EnumTipoSenhaAtendimento;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class PainelSenhaDTO extends AbstractDTO {
    private String tituloGuiche;

    private String senhaExtensoSenhaAtendimento;

    private Integer posicaoGuiche;

    private Integer senha;

    @Enumerated(EnumType.STRING)
    private EnumTipoSenhaAtendimento tipoSenhaSenhaAtendimento;

    @Enumerated(EnumType.STRING)
    private EnumSenhaPainel senhaPainelSenhaAtendimento;

    private String abreviacaoTipoSenhaAtendimento;

    private String tituloTipoSenhaAtendimento;
}
