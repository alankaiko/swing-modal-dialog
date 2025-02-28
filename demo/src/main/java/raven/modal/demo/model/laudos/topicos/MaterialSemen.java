package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumElevado;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class MaterialSemen extends AbstractEntity {
    private LocalDate dataMaterial;
    private String material;
    private Double volume;
    private String concentracao;

    @Enumerated(EnumType.STRING)
    private EnumElevado elevado;

    private Double moveistra;
    private Double moveistrb;
    private Double moveistrc;
    private Double moveissitu;
}
