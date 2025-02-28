package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "encaminharpaciente")
public class EncaminharPaciente extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "tbl_medico_id", referencedColumnName = "codigo")
    private Profissional medico;

    @ManyToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;

    @Column(length = 10000)
    private String texto;
}
