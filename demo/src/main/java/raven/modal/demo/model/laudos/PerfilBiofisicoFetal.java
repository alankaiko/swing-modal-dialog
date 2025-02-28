package raven.modal.demo.model.laudos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.model.ProcedimentoAtendimento;
import raven.modal.demo.model.enuns.EnumPresenca;
import raven.modal.demo.model.laudos.topicos.CardiotocografiaFetal;
import raven.modal.demo.model.laudos.topicos.IdadeGestacional;
import raven.modal.demo.model.laudos.topicos.LaudoPadrao;
import raven.modal.demo.model.laudos.topicos.TextoSugestivo;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "perfilbiofisicofetal")
public class PerfilBiofisicoFetal extends LaudoPadrao {

    @ManyToOne
    @JoinColumn(name = "tbl_procedimento_atendimento_id", referencedColumnName = "codigo")
    private ProcedimentoAtendimento procedimentoAtendimento;

    @Column(length = 2000)
    private String observacaoCardiologiaFetal;

    @Column(length = 2000)
    private String conclusaoCardiologiaFetal;

    @Column(length = 2000)
    private String observacaoPerfil;

    @Column(length = 2000)
    private String observacaoConclusaoPerfil;

    @Enumerated(EnumType.STRING)
    private EnumPresenca reatividadeCardiaca;

    @Enumerated(EnumType.STRING)
    private EnumPresenca movimentosFetais;

    @Enumerated(EnumType.STRING)
    private EnumPresenca movimentosRespiratorios;

    @Enumerated(EnumType.STRING)
    private EnumPresenca tonusFetal;

    @Enumerated(EnumType.STRING)
    private EnumPresenca volumeLiquido;

    private double medidaUm;

    private double medidaDois;

    private double medidaTres;

    private double medidaQuatro;

    private double somaMedidas;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_cardiotocografia_fetal_id", referencedColumnName = "codigo")
    private CardiotocografiaFetal cardiotocografiaFetal;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_idade_gestacional_id", referencedColumnName = "codigo")
    private IdadeGestacional idadeGestacional;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_perfil_biofisico_fetal_id", referencedColumnName = "codigo")
    private PerfilBiofisicoFetal perfilBiofisicoFetal;

    @Column(length = 1500)
    private String observacoesGerais;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_impressao_diagnostica_id", referencedColumnName = "codigo")
    private TextoSugestivo impressaoDiagnostica;

    private String observacaoCardiotocografiaFetal;

    private String conclusaoCardiotocografiaFetal;

}
