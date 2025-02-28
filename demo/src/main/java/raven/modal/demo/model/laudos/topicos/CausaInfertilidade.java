package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "causainfertilidade")
public class CausaInfertilidade extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumSimNao tubario;

    @Enumerated(EnumType.STRING)
    private EnumSimNao masculino;

    @Enumerated(EnumType.STRING)
    private EnumSimNao endometriose;

    @Enumerated(EnumType.STRING)
    private EnumSimNao esca;

    @Enumerated(EnumType.STRING)
    private EnumSimNao ovulatorio;

    @Enumerated(EnumType.STRING)
    private EnumSimNao cervical;

    @Enumerated(EnumType.STRING)
    private EnumSimNao imunologico;

    @Enumerated(EnumType.STRING)
    private EnumSimNao coital;

    @Enumerated(EnumType.STRING)
    private EnumSimNao reservadiminuida;

    @Enumerated(EnumType.STRING)
    private EnumSimNao endometrial;

    @Enumerated(EnumType.STRING)
    private EnumSimNao uterinoanatomico;

    @Enumerated(EnumType.STRING)
    private EnumSimNao doencasmaternas;

    @Enumerated(EnumType.STRING)
    private EnumSimNao geneticopaterno;

    @Enumerated(EnumType.STRING)
    private EnumSimNao geneticomaterno;

    @Enumerated(EnumType.STRING)
    private EnumSimNao cancer;

    @Enumerated(EnumType.STRING)
    private EnumSimNao preservacaofertilidade;

    @Enumerated(EnumType.STRING)
    private EnumSimNao sorodiscordante;

    @Enumerated(EnumType.STRING)
    private EnumSimNao casalhomoafetivo;

    @Enumerated(EnumType.STRING)
    private EnumSimNao semregistro;
}
