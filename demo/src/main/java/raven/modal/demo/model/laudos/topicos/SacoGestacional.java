package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumInsercao;
import raven.modal.demo.model.enuns.EnumRegular;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sacogestacional")
public class SacoGestacional extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumInsercao insercao;

    @Enumerated(EnumType.STRING)
    private EnumRegular forma;

    private float diametrol;
    private float diametroap;
    private float diametrot;
    private float mediadiametro;

    @Column(length = 500)
    private String texto;
}
