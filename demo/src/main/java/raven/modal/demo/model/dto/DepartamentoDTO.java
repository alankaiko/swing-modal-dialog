package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;
import raven.modal.demo.model.UnidadeComp;

@Getter
@Setter
public class DepartamentoDTO extends AbstractDTO {
    private Long codigo;
    private String nome;
    private String descricao;
    private String senha;
    private UnidadeComp unidade;
}
