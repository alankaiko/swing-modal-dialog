package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumAspecto;
import raven.modal.demo.model.enuns.EnumLimite;
import raven.modal.demo.model.enuns.EnumPresenca;
import raven.modal.demo.model.enuns.EnumRegular;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Endometrio extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumPresenca enumPresenca;

    @Enumerated(EnumType.STRING)
    private EnumAspecto enumAspecto;

    private boolean dadosAdicionais;

    @Enumerated(EnumType.STRING)
    private EnumLimite enumLimite;

    @Enumerated(EnumType.STRING)
    private EnumRegular enumContorno;

    private Double espessura;

    @Column(length = 500)
    private String texto;
}
