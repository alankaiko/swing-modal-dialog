package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumLaudoEquipamentoTipo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "laudoequipamento")
public class LaudoEquipamento extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumLaudoEquipamentoTipo tipoequipamento;
    private String frequencia;

    private LocalDate dataexame;
}
