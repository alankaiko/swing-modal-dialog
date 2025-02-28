package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumBIRads;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "birads")
public class BIRads extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumBIRads enumBIRads;

    @Enumerated(EnumType.STRING)
    private EnumBIRads mamaEsquerda;

    @Enumerated(EnumType.STRING)
    private EnumBIRads mamaDireita;
}
