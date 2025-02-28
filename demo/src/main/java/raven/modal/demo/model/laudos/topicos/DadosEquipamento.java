package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumTipoDadosEquipamento;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "dadosequipamento")
public class DadosEquipamento extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumTipoDadosEquipamento enumTipoDadosEquipamento;
    private Float frequencia;

    private LocalDate data;

    private String texto;
}
