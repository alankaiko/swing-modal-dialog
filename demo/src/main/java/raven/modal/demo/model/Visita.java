package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class Visita extends AbstractEntity {
    private LocalDate ultimoatendimento;

    @Column(length = 500)
    private String descricao;

    @OneToOne
    @JoinColumn(name = "tbl_medicoa_id", referencedColumnName = "codigo")
    private Profissional medico;

    @OrderBy
    private LocalDate datavisita;

    @OneToOne
    @JoinColumn(name = "tbl_tipodoatendimento_id", referencedColumnName = "codigo")
    private TipodoAtendimento tipodoatendimento;
    private String plano;

    @OneToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "tbl_convenio_id", referencedColumnName = "codigo")
    private Convenio convenio;

    @Enumerated(EnumType.STRING)
    private EnumSimNao simnao;

    private LocalDate dataobservacao;

    private String valores;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_id", referencedColumnName = "codigo")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "tbl_unidade_comp", referencedColumnName = "codigo")
    private UnidadeComp unidade;
    private Integer tentativa;
}
