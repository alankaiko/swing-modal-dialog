package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

@Getter
@Setter
public class ProfissionalDTO extends AbstractDTO {
    private String nome;
    private Long codigoexaminador;
    private String tissdescricao;
    private String sigladescricao;
    private boolean desativado;
}
