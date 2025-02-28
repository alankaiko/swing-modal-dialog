package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumDescrito;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Vagina extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumDescrito enumVagina;

    @Column(length = 500)
    private String texto;
}
