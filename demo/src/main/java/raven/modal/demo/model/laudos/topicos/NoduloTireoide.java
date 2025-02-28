package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "nodulotireoide")
public class NoduloTireoide extends AbstractEntity {
    private float diametrol;
    private float diametroap;
    private float diametrot;
    private float volume;

    @Enumerated(EnumType.STRING)
    private EnumLocalizacaoTireoide localizacao;

    @Enumerated(EnumType.STRING)
    private EnumTerco terco;

    @Enumerated(EnumType.STRING)
    private EnumComposicao composicao;

    @Enumerated(EnumType.STRING)
    private EnumEcogenicidade ecogenicidade;

    @Enumerated(EnumType.STRING)
    private EnumFormaNoduloTireoide forma;

    @Enumerated(EnumType.STRING)
    private EnumMargemNoduloTireoide margem;

    @Enumerated(EnumType.STRING)
    private EnumFocoEcogenico focoEcogenicoUm;

    @Enumerated(EnumType.STRING)
    private EnumFocoEcogenico focoEcogenicoDois;

    @Enumerated(EnumType.STRING)
    private EnumFocoEcogenico focoEcogenicoTres;

    @Enumerated(EnumType.STRING)
    private EnumFocoEcogenico focoEcogenicoQuatro;

    private int pontos;
    private int pontoTiRads;
    private String classificacao;
    private String condutaSugerida;

    @Enumerated(EnumType.STRING)
    private EnumRegular contorno;

    @Enumerated(EnumType.STRING)
    private EnumLimite limite;

    @Enumerated(EnumType.STRING)
    private EnumClassificacaoTireoide classificacaoTireoide;

    @Enumerated(EnumType.STRING)
    private EnumRazaoVascular razao;

    private String razaoDescricao;

    @Enumerated(EnumType.STRING)
    private EnumSimNao descricaoComplementar;

    private String descricao;
}
