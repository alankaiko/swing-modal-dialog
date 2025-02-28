package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class Guia extends AbstractEntity {
    private LocalDate dataconsulta;
    private String nomesegurado;
    private String matricula;
    private String validade;
    private String documento;
    private String cpf;
    private String email;
    private String alteracaopaciente;
    private String plano;
    private String saldofisioterapia;
    private String saldo;
    private String senhasite;

    @OneToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;
}
