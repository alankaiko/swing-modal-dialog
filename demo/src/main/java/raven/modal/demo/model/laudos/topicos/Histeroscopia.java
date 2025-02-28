package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.model.ProcedimentoAtendimento;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Histeroscopia extends LaudoPadrao {

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

    @Enumerated(EnumType.STRING)
    private EnumSimNao biopsiaSimNao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_procedimento_realizado_id", referencedColumnName = "codigo")
    private TextoSugestivo procedimentoRealizado;

    @Column(length = 1500)
    private String observacaoSedundaria;

    @Column(length = 1500)
    private String observacoesGerais;
}