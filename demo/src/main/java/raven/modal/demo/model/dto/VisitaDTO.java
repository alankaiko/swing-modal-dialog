package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

import java.time.LocalDate;

@Getter
@Setter
public class VisitaDTO extends AbstractDTO {
    private LocalDate ultimoatendimento;
    private String mediconome;
    private LocalDate datavisita;
    private String plano;
    private String titulotipo;
    private String pacientenome;
    private String tipopatendimentonome;
    private String tipoatendimentodescricao;
    private Long idPaciente;
}
