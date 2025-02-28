package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

@Getter
@Setter
public class UnidadeCompDTO extends AbstractDTO {
    private String nomeunidade;
    private String descricao;
    private String cnpj;
    private String razaosocial;
    private boolean ativo;
}
