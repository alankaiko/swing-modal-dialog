package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "massaanexialencontrada")
public class MassaAnexialEncontrada extends AbstractEntity {
    private double diametrol;
    private double diametroap;
    private double diametrot;

    @Enumerated(EnumType.STRING)
    private EnumClassificacaoMassa classificacaoMassa;

    private double diametroParteSolida;

    @Enumerated(EnumType.STRING)
    private EnumConteudo conteudo;

    @Enumerated(EnumType.STRING)
    private EnumRegular contornos;

    @Enumerated(EnumType.STRING)
    private EnumPresenca sombaAcustica;

    @Enumerated(EnumType.STRING)
    private EnumTentativa numeroLoculos;

    @Enumerated(EnumType.STRING)
    private EnumTentativa numeroProjecoes;

    private double medidaProjecaoBase;
    private double medidaProjecaoAltura;

    @Enumerated(EnumType.STRING)
    private EnumPresenca fluxoSangue;

    @Enumerated(EnumType.STRING)
    private EnumMassaVascularizar massaVascularizar;

    private double riscoIota;

    @Enumerated(EnumType.STRING)
    private EnumSimNao simNao;

    @Column(length = 1000)
    private String descricaoAdicional;
}
