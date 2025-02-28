package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumDirecao;
import raven.modal.demo.model.enuns.EnumFontReport;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "configuracaolaudo")
public class ConfiguracaoLaudo extends AbstractEntity {
    private String titulo;
    private boolean ativo;
    private boolean mostrartitulorodape;
    private float margemtopo;
    private float margemrodape;
    private float margemesquerda;
    private float margemdireita;
    private boolean possuilogo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_imagem_id", referencedColumnName = "codigo")
    private Imagem logo;
    private float logolargura;
    private float logoaltura;

    @Enumerated(EnumType.STRING)
    private EnumDirecao direcaoLogo;

    private float logopaddingtop;
    private float logopaddingbottom;
    private float logopaddingleft;
    private float logopaddinglright;
    private boolean mostrarnomeunidade;

    @OneToOne
    @JoinColumn(name = "tbl_unidade_id", referencedColumnName = "codigo")
    private UnidadeComp unidade;
    private String textorodape;

    @Enumerated(EnumType.STRING)
    private EnumSimNao laudomedico;

    @Enumerated(EnumType.STRING)
    private EnumDirecao direcaodescricao;

    @Enumerated(EnumType.STRING)
    private EnumFontReport fontreport;
    private Integer tamanhofonte;

}
