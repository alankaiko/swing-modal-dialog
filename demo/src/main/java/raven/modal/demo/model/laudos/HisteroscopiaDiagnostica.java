package raven.modal.demo.model.laudos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.model.ProcedimentoAtendimento;
import raven.modal.demo.model.laudos.topicos.LaudoPadrao;
import raven.modal.demo.model.laudos.topicos.TextoSugestivo;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "histeroscopiadiagnostica")
public class HisteroscopiaDiagnostica extends LaudoPadrao {

    @ManyToOne
    @JoinColumn(name = "tbl_procedimento_atendimento_id", referencedColumnName = "codigo")
    private ProcedimentoAtendimento procedimentoAtendimento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_dados_tecnicos_id", referencedColumnName = "codigo")
    private TextoSugestivo dadosTecnicos;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_canal_cervical_id", referencedColumnName = "codigo")
    private TextoSugestivo canalCervical;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_orificio_interno_colo_uterino_id", referencedColumnName = "codigo")
    private TextoSugestivo orificioInterno;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_cavidade_endometrial_id", referencedColumnName = "codigo")
    private TextoSugestivo cavidadeEndometrial;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_ostios_tubarios_id", referencedColumnName = "codigo")
    private TextoSugestivo ostiosTubarios;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_biopsia_id", referencedColumnName = "codigo")
    private TextoSugestivo biopsia;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_procedimento_realizado_id", referencedColumnName = "codigo")
    private TextoSugestivo procedimentoRealizado;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_impressao_diagnostica_id", referencedColumnName = "codigo")
    private TextoSugestivo impressaoDiagnostica;

    @Column(length = 1500)
    private String observacoesGerais;
}
