package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "recibopaciente")
public class ReciboPaciente extends AbstractEntity {
    private Integer numero;
    private double valor;

    @Column(length = 600)
    private String texto;

    @ManyToOne
    @JoinColumn(name = "tbl_medico_id", referencedColumnName = "codigo")
    private Profissional medico;

    @ManyToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;
}
