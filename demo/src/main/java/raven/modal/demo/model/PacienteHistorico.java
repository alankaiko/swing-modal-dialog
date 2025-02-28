package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pacientehistorico")
public class PacienteHistorico extends AbstractEntity {
    @Column(length = 5800)
    private String textoconsulta;

    @Column(length = 5800)
    private String textoconduta;

    @Column(length = 5800)
    private String textohipotese;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "tbl_profissional_id", referencedColumnName = "codigo")
    private Profissional profissional;
}
