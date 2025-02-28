package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

@Getter
@Setter
public class EstudoDTO extends AbstractDTO {
    private String accessionnumber;
    private String studyinstanceuid;
    private String studydescription;
}
