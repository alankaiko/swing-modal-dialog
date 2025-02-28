package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumAspecto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Table(name = "ovariofoliculos")
@Entity
public class OvarioFoliculos extends AbstractEntity {
    private LocalDate data;
    private int nummed;
    private int diacic;
    private int diaind;
    private int cfadireito;
    private String ovariodireito;
    private int cfaesquerdo;
    private String ovarioesquerdo;
    private float endo;
    private int muco;

    @Enumerated(EnumType.STRING)
    private EnumAspecto tipo;
}
