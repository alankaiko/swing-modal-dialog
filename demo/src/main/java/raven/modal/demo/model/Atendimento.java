package raven.modal.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;
import raven.modal.demo.model.enuns.EnumStatusAgendamento;
import raven.modal.demo.model.enuns.EnumTipoAtendimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table
public class Atendimento extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    private EnumStatusAgendamento statusagendamento;

    @ManyToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "tbl_convenio_id", referencedColumnName = "codigo")
    private Convenio convenio;

    @OneToOne
    @JoinColumn(name = "tbl_medico_id", referencedColumnName = "codigo")
    private Profissional medico;
    private LocalDate dataatendimento;
    private String horachegada;

    private Date datainicio;

    private Date datafim;

    @Enumerated(EnumType.STRING)
    private EnumTipoAtendimento tipodoatendimento;

    @OneToOne
    @JoinColumn(name = "tbl_unidade_id", referencedColumnName = "codigo")
    private UnidadeComp unidade;

    @OneToOne
    @JoinColumn(name = "tbl_departamento_id", referencedColumnName = "codigo")
    private Departamento departamento;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_id", referencedColumnName = "codigo")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProcedimentoAtendimento> procedimentos;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MedicamentoProcedimento> medicamentos;

    @Enumerated(EnumType.STRING)
    private EnumSimNao pacienteconfirmado;

    @OneToOne
    @JoinColumn(name = "tbl_tipoparaagendamento_id", referencedColumnName = "codigo")
    private TipoParaAgendamento tipoparaagendamento;

    @Column(length = 3000)
    private String observacao;

    private Integer numeroguias;

    private String numerocarteira;

    private BigDecimal valortotal;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_guia_convenio_id", referencedColumnName = "codigo")
    private GuiaConvenio guiaConvenio;

    @OneToOne
    @JoinColumn(name = "tbl_editado_por_id", referencedColumnName = "codigo")
    private Usuario editadoPor;

    private Date dataAlteracaoPacienteConfirmado;

    private Integer codigoAlteracaoPacienteConfirmado;

    private Date validadecarteira;

    @Transient
    private Date database;
}
