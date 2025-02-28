package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Feto extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumPresenca presenca;

    @Enumerated(EnumType.STRING)
    private EnumPresenca batimentos;
    private int numeroBatimentos;

    @Enumerated(EnumType.STRING)
    private EnumVesicula vesicula;

    @Enumerated(EnumType.STRING)
    private EnumInformado translucencia;
    private float translucenciaNucal;

    @Enumerated(EnumType.STRING)
    private EnumPresenca ossoNasal;
    private float medidaOssoNasal;

    @Enumerated(EnumType.STRING)
    private EnumInformado anguloMaxilar;
    private float medidaFrontoMaxilar;

    @Enumerated(EnumType.STRING)
    private EnumDuctoVenoso ductoVenoso;

    @Enumerated(EnumType.STRING)
    private EnumDescrito estudoMofologico;

    private String estudoMorfologicoDescrito;

    @Enumerated(EnumType.STRING)
    private EnumMovimentos movimentos;

    @Enumerated(EnumType.STRING)
    private EnumPresenca membranaAmniotica;

    @Enumerated(EnumType.STRING)
    private EnumPresenca regurgitacao;

    @Column(length = 500)
    private String descricaoAdicional;

    @Enumerated(EnumType.STRING)
    private EnumSituacaoFeto situacao;

    @Enumerated(EnumType.STRING)
    private EnumApresentacaoFeto apresentacao;

    @Enumerated(EnumType.STRING)
    private EnumDorso dorso;

    @Enumerated(EnumType.STRING)
    private EnumPresenca movimentosRespiratorios;

    @Enumerated(EnumType.STRING)
    private EnumRitmo ritmo;

    @Column(length = 500)
    private String texto;

    @Enumerated(EnumType.STRING)
    private EnumSexoFeto sexoFeto;

    @Enumerated(EnumType.STRING)
    private EnumPresenca gorduraPrePeritonial;

    @Enumerated(EnumType.STRING)
    private EnumMaturidade estadiamento;

    private Double diametroVentricular;
    private Double cisternaMagna;
    private Double pregaNucal;
    private Double distanciaInterOrbitaria;
}
