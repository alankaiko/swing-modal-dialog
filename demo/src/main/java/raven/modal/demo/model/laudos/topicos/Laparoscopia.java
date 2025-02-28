package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.ProcedimentoAtendimento;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "laparoscopia")
public class Laparoscopia extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "tbl_procedimento_atendimento_id", referencedColumnName = "codigo")
    private ProcedimentoAtendimento procedimentoAtendimento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_realizacao_laparoscopia_id", referencedColumnName = "codigo")
    private TextoSugestivo realizacaoLaparoscopia;

    private String medida;

    private Long medidaUm;

    private Long medidaDois;

    private Long medidaTres;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_cavidade_peritonial_id", referencedColumnName = "codigo")
    private TextoSugestivo cavidadePeritonial;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_bexiga_id", referencedColumnName = "codigo")
    private TextoSugestivo bexiga;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_utero_id", referencedColumnName = "codigo")
    private TextoSugestivo utero;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_tuba_direito_id", referencedColumnName = "codigo")
    private TextoSugestivo tubaDireito;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_tuba_esquerdo_id", referencedColumnName = "codigo")
    private TextoSugestivo tubaEsquerdo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_ovario_direito_id", referencedColumnName = "codigo")
    private TextoSugestivo ovarioDireito;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_ovario_esquerdo_id", referencedColumnName = "codigo")
    private TextoSugestivo ovarioEsquerdo;

    @Enumerated(EnumType.STRING)
    private EnumSimNao biopsia;

    @Column(length = 500)
    private String procedimentoRealizado;

    @Column(length = 500)
    private String conclusao;
}
