package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumDescrito;
import raven.modal.demo.model.enuns.EnumLateral;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Lifandenomegalia extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumDescrito ocorrencia;

    @Enumerated(EnumType.STRING)
    private EnumLateral tipo;

    @Column(length = 500)
    private String texto;

    private boolean la;
    private boolean lb;
    private boolean lla;
    private boolean llb;
    private boolean lll;
    private boolean lva;
    private boolean lvb;
    private boolean va;
    private boolean vb;
}
