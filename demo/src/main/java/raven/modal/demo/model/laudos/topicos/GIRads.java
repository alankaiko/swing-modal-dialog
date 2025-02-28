package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumGIRads;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "girads")
public class GIRads extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumGIRads enumGIRads;

    @Enumerated(EnumType.STRING)
    private EnumGIRads ovarioEsquerdo;

    @Enumerated(EnumType.STRING)
    private EnumGIRads ovarioDireito;
}
