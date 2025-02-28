package raven.modal.demo.model.laudos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.model.ProcedimentoAtendimento;
import raven.modal.demo.model.laudos.topicos.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "mamasaxilasbilateral")
public class MamasAxilasBilateral extends LaudoPadrao {

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
    @JoinColumn(name = "tbl_mama_direita_id", referencedColumnName = "codigo")
    private TextoSugestivo mamaDireita;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_mama_direita_aero_papilar_id", referencedColumnName = "codigo")
    private TextoSugestivo mamaDireitaAeroPapilar;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_mama_direita_subcutaneo_id", referencedColumnName = "codigo")
    private TextoSugestivo mamaDireitaSubcutaneo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_mama_direita_parenquima_id", referencedColumnName = "codigo")
    private TextoSugestivo mamaDireitaParenquima;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_mama_direita_retromaria_id", referencedColumnName = "codigo")
    private TextoSugestivo mamaDireitaRetromamaria;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_descricao_nodulo_mama_direita_id", referencedColumnName = "codigo")
    private DescricaoNodulo descricaoNoduloMamaDireita;

    @Column(length = 500)
    private String mamaDireitaObs;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_mama_esquerda_id", referencedColumnName = "codigo")
    private TextoSugestivo mamaEsquerda;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_mama_esquerda_aero_papilar_id", referencedColumnName = "codigo")
    private TextoSugestivo mamaEsquerdaAeroPapilar;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_mama_esquerda_subcutaneo_id", referencedColumnName = "codigo")
    private TextoSugestivo mamaEsquerdaSubcutaneo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_mama_esquerda_parenquima_id", referencedColumnName = "codigo")
    private TextoSugestivo mamaEsquerdaParenquima;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_mama_esquerda_retromaria_id", referencedColumnName = "codigo")
    private TextoSugestivo mamaEsquerdaRetromamaria;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_descricao_nodulo_mama_esquerda_id", referencedColumnName = "codigo")
    private DescricaoNodulo descricaoNoduloMamaEsquerda;

    @Column(length = 500)
    private String mamaEsquerdaObs;

    @Column(length = 1500)
    private String observacoesGerais;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_birads_id", referencedColumnName = "codigo")
    private BIRads biRads;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_impressao_diagnostica_id", referencedColumnName = "codigo")
    private TextoSugestivo impressaoDiagnostica;
}
