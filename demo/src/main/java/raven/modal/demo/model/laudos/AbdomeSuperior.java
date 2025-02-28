package raven.modal.demo.model.laudos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.model.ProcedimentoAtendimento;
import raven.modal.demo.model.laudos.topicos.CalculoVolume;
import raven.modal.demo.model.laudos.topicos.DadosEquipamento;
import raven.modal.demo.model.laudos.topicos.LaudoPadrao;
import raven.modal.demo.model.laudos.topicos.TextoSugestivo;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "abdomesuperior")
public class AbdomeSuperior extends LaudoPadrao {

    @ManyToOne
    @JoinColumn(name = "tbl_procedimento_atendimento_id", referencedColumnName = "codigo")
    private ProcedimentoAtendimento procedimentoAtendimento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_dados_equipamento_id", referencedColumnName = "codigo")
    private DadosEquipamento dadosEquipamento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_figado_id", referencedColumnName = "codigo")
    private TextoSugestivo figado;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_vias_biliares_id", referencedColumnName = "codigo")
    private TextoSugestivo viasBiliares;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_vesicula_biliar_id", referencedColumnName = "codigo")
    private TextoSugestivo vesiculaBiliar;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_pancreas_id", referencedColumnName = "codigo")
    private TextoSugestivo pancreas;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_rim_direito_id", referencedColumnName = "codigo")
    private CalculoVolume rimDireito;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_rim_esquerdo_id", referencedColumnName = "codigo")
    private CalculoVolume rimEsquerdo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_baco_id", referencedColumnName = "codigo")
    private TextoSugestivo baco;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_vasos_id", referencedColumnName = "codigo")
    private TextoSugestivo vasos;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_retroperitonio_id", referencedColumnName = "codigo")
    private TextoSugestivo retroperitonio;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_seios_costofrenicos_id", referencedColumnName = "codigo")
    private TextoSugestivo seiosCostoFrenicos;

    @Column(length = 1500)
    private String observacoesGerais;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_impressao_diagnostica_id", referencedColumnName = "codigo")
    private TextoSugestivo impressaoDiagnostica;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_demais_orgaos_pelvicos_id", referencedColumnName = "codigo")
    private TextoSugestivo demaisOrgaosPelvicos;
}
