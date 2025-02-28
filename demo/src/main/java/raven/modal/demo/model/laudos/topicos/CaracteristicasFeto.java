package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumTipoGravidez;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "caracteristicasfeto")
public class CaracteristicasFeto extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    private EnumTipoGravidez tipoGravidez;

    private int tamanhoFeto;

    private int tamanhoFeto2;

    private LocalDate dataExame;
}






















