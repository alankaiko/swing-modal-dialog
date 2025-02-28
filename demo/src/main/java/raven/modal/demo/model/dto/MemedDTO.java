package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;
import raven.modal.demo.model.Medicamento;

import java.util.List;

@Getter
@Setter
public class MemedDTO extends AbstractDTO {
    private String token;
    private String nomeProtocolo;
    private List<Medicamento> medicamentos;
}
