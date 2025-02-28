package raven.modal.demo.model.laudos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.model.ProcedimentoAtendimento;
import raven.modal.demo.model.laudos.topicos.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "transvaginalpreparo")
public class TransvaginalPreparo extends LaudoPadrao {

    @ManyToOne
    @JoinColumn(name = "tbl_procedimento_atendimento_id", referencedColumnName = "codigo")
    private ProcedimentoAtendimento procedimentoAtendimento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_dados_equipamento_id", referencedColumnName = "codigo")
    private DadosEquipamento dadosEquipamento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_ciclo_menstrual_id", referencedColumnName = "codigo")
    private CicloMenstrual ciclomenstrual;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_bexiga_id", referencedColumnName = "codigo")
    private Bexiga bexiga;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_vagina_id", referencedColumnName = "codigo")
    private Vagina vagina;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_utero_id", referencedColumnName = "codigo")
    private Utero utero;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_endometrio_id", referencedColumnName = "codigo")
    private Endometrio endometrio;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_ovario_direito_id", referencedColumnName = "codigo")
    private Ovario ovarioDireito;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_ovario_esquerdo_id", referencedColumnName = "codigo")
    private Ovario ovarioEsquerdo;

    @Column(length = 1500)
    private String observacoesGerais;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_saco_douglas_id", referencedColumnName = "codigo")
    private SacoDouglas sacoDouglas;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_impressao_diagnostica_id", referencedColumnName = "codigo")
    private TextoSugestivo impressaoDiagnostica;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_compartimento_posterior_pelve_id", referencedColumnName = "codigo")
    private TextoSugestivo compartimentoPosteriorPelve;

    @Column(length = 1500)
    private String observacaoSedundaria;

}
