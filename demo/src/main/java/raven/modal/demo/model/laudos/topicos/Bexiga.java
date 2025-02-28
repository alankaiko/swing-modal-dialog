package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumBexiga;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "laudobexiga")
public class Bexiga extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumBexiga enumBexiga;

    @Column(length = 500)
    private String texto;
}
