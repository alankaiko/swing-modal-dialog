package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumAcompanhante;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Table
@Entity
public class Atestado extends AbstractEntity {
    private String horaatendimento;

    @ManyToOne
    @JoinColumn(name = "tabela_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;
    private String acompanhante;
    private EnumAcompanhante tipoacompanhante;
    private int escolhatipo;
    private String horainiciocomparecimento;
    private String horaterminocomparecimento;
    private String motivocomparecimento;
    private Integer necessitadias;

    private LocalDate necessitadata;
    private boolean atestadoacompanhante;
    private String devevoltarpara;
    private String observacao;

    private LocalDate dataimpressao;
    private boolean imprimido;

    @Column(length = 3000)
    private String textoCompilado;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_id", referencedColumnName = "codigo")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "tbl_medico_id", referencedColumnName = "codigo")
    private Profissional medico;

    private String campocid;
}
