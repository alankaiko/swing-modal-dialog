package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "fichadoador")
public class FichaDoador extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "tbl_doador_id", referencedColumnName = "codigo")
    private Doador doador;

    @Enumerated(EnumType.STRING)
    private EnumSimNao examegoiania;

    @Enumerated(EnumType.STRING)
    private EnumSimNao plano;

    private String nomeplano;

    @Enumerated(EnumType.STRING)
    private EnumGrupoSanguineo gruposanguineo;

    @Enumerated(EnumType.STRING)
    private EnumCor raca;

    private String origem;

    private String escolaridade;

    private String profissao;

    private String religiao;

    private String signo;

    @Enumerated(EnumType.STRING)
    private EnumCor corpele;

    @Enumerated(EnumType.STRING)
    private EnumCorCabelo corcabelo;

    @Enumerated(EnumType.STRING)
    private EnumTexturaCabelo texturacabelo;

    @Enumerated(EnumType.STRING)
    private EnumCorOlhos corolhos;

    @Enumerated(EnumType.STRING)
    private EnumSimNao historicodoencas;

    private String doencatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao vasectomia;

    private String vasectomiatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao testosterona;

    private String testosteronatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao malformacao;

    private String malformacaotexto;

    private String altura;

    private String peso;

    @Enumerated(EnumType.STRING)
    private EnumSimNao filhos;

    @Enumerated(EnumType.STRING)
    private EnumSexo sexoFilho;

    private String saudefilhos;

    @Enumerated(EnumType.STRING)
    private EnumSimNao infertilidade;

    @Enumerated(EnumType.STRING)
    private EnumSimNao fumante;

    @Enumerated(EnumType.STRING)
    private EnumTipoFumo tipoFumo;

    @Enumerated(EnumType.STRING)
    private EnumBeneficiario beneficiario;

    private String beneficiariotexto;

    @Column(length = 3500)
    private String observacao;

    @OneToOne
    @JoinColumn(name = "tbl_profissional_id", referencedColumnName = "codigo")
    private Profissional profissional;

    @Enumerated(EnumType.STRING)
    private EnumSimNao doencafamilia;

    private String doencafamiliatexto;

    private String imc;

    private boolean avaliado;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Imagem> imagens;

    @Embedded
    private Endereco endereco;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_termo_ficha_doador_id", referencedColumnName = "codigo")
    private TermoFichaDoador termoFichaDoador;

    @Enumerated(EnumType.STRING)
    private EnumSimNao aprovado;
}
