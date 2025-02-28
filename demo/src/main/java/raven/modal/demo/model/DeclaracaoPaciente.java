package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Delaracaopaciente")
public class DeclaracaoPaciente extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;

    private String comparecimento;

    private String localComparecimento;

    private Boolean examesLaboratoriais;

    private Boolean tratamentoAmbulatorial;

    private Boolean acompanhamentoFamiliar;

    private String nomePrimeiro;

    private String nomeSegundo;

    private String nomeTerceiro;

    private String turno;

    private LocalDate dataComparecimento;

    @Column(length = 10000)
    private String texto;
}
