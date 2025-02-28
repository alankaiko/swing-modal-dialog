package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

@Getter
@Setter
public class TipodoAtendimentoDTO extends AbstractDTO {
    private String tipoatendimento;
    private String descricao;
    private String gruponome;
    private boolean ativo;
}
