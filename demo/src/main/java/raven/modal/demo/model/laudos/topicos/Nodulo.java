package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table
public class Nodulo extends AbstractEntity {
    private float diametrol;
    private float diametroap;
    private float diametrot;
    private float volume;

    @Enumerated(EnumType.STRING)
    private EnumTexturaNodulo textura;

    @Enumerated(EnumType.STRING)
    private EnumRegular contornos;

    @Enumerated(EnumType.STRING)
    private EnumLimite limite;

    @Enumerated(EnumType.STRING)
    private EnumLocalizacao localizacao;

    private int horas;
    private String profundidade;
    private String distanciaMamilo;

    @Column(length = 500)
    private String descricaoComplementar;

    @Enumerated(EnumType.STRING)
    private EnumFormaNodulo forma;

    @Enumerated(EnumType.STRING)
    private EnumOrientacao orientacao;

    @Enumerated(EnumType.STRING)
    private EnumMargemNodulo margem;

    @Enumerated(EnumType.STRING)
    private EnumLimiteBirads limiteBirads;

    @Enumerated(EnumType.STRING)
    private EnumEcogenicidade padraoEco;

    @Enumerated(EnumType.STRING)
    private EnumAcusticaPosterior acusticaPosterior;

    @Enumerated(EnumType.STRING)
    private EnumTecidoCircundante tecidoCircundante;

    @Enumerated(EnumType.STRING)
    private EnumCalcificacoes calcificacoes;

    @Enumerated(EnumType.STRING)
    private EnumVascularizacao vascularizacao;

    @Column(length = 500)
    private String texto;
}