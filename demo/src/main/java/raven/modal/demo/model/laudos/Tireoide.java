package raven.modal.demo.model.laudos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.model.ProcedimentoAtendimento;
import raven.modal.demo.model.laudos.topicos.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tireoide")
public class Tireoide extends LaudoPadrao {

    @ManyToOne
    @JoinColumn(name = "tbl_procedimento_atendimento_id", referencedColumnName = "codigo")
    private ProcedimentoAtendimento procedimentoAtendimento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_dados_equipamento_id", referencedColumnName = "codigo")
    private DadosEquipamento dadosEquipamento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_pele_id", referencedColumnName = "codigo")
    private TextoSugestivo pele;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_musculo_pre_pireoidianos_id", referencedColumnName = "codigo")
    private TextoSugestivo musculoPreTireoidianos;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_carotidas_id", referencedColumnName = "codigo")
    private TextoSugestivo carotidas;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_lifandenomegalia_id", referencedColumnName = "codigo")
    private Lifandenomegalia lifandenomegalia;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_tireoide_id", referencedColumnName = "codigo")
    private TextoSugestivo tireoide;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_vacularizar_id", referencedColumnName = "codigo")
    private Vascularizar vascularizar;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_lobo_direito_id", referencedColumnName = "codigo")
    private CalculoVolume loboDireito;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_lobo_esquerdo_id", referencedColumnName = "codigo")
    private CalculoVolume loboEsquerdo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_tireoide_istmo_id", referencedColumnName = "codigo")
    private CalculoVolume tireoideIstmo;

    @Column(length = 1500)
    private String observacoesGerais;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_impressao_diagnostica_id", referencedColumnName = "codigo")
    private TextoSugestivo impressaoDiagnostica;

}
