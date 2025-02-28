package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumDuctoVenoso;
import raven.modal.demo.model.enuns.EnumVeiaUmbilical;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table
public class Ducto extends AbstractEntity {
    private double ip;

    @Enumerated(EnumType.STRING)
    private EnumDuctoVenoso diastole;

    @Enumerated(EnumType.STRING)
    private EnumVeiaUmbilical veiaUmbilical;
}
