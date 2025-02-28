package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

@Getter
@Setter
public class ExameDTO extends AbstractDTO {
    private String titulo;
    private String tituloGrupo;
    private String codigoabrev;
}
