package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumAmniotico;
import raven.modal.demo.model.enuns.EnumCanalEndocervical;
import raven.modal.demo.model.enuns.EnumCordaoUmbilical;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "informacoesfeto")
@Table
public class InformacoesFeto extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    private EnumCordaoUmbilical cordaoUmbilical;

    @Enumerated(EnumType.STRING)
    private EnumAmniotico liquidoAmniotico;

    @Enumerated(EnumType.STRING)
    private EnumCanalEndocervical canalEndocervical;

    private double medidaUm;

    private double medidaDois;

    private double medidaTres;

    private double medidaQuatro;

    private double somaMedidas;
}
