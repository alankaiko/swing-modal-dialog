package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

@Getter
@Setter
public class InstanciaDTO extends AbstractDTO {
    private Integer instancenumber;
    private String mediastoragesopinstanceuid;
    private String sopinstanceuid;
    private String sopclassuid;
    private String transfersyntaxuid;
}
