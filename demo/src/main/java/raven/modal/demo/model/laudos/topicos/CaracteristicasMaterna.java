package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumCor;
import raven.modal.demo.model.enuns.EnumMedicamentoDiabete;
import raven.modal.demo.model.enuns.EnumMetodoConcepcao;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "caracteristicasmaterna")
public class CaracteristicasMaterna extends AbstractEntity {
    private LocalDate dataNascimento;

    private float altura;
    private float peso;
    private EnumCor raca;
    private boolean tabagismo;
    private boolean ep;

    @Enumerated(EnumType.STRING)
    private EnumMetodoConcepcao metodoConcepcao;

    private boolean hipertensao;
    private boolean diabetes1;
    private boolean diabetes2;

    @Enumerated(EnumType.STRING)
    private EnumMedicamentoDiabete medicamentoDiabete;

    private boolean lupus;
    private boolean antifosfolipide;
    private boolean nuliparas;
    private boolean parosa;

    private boolean preEclampsia;

    private LocalDate dataEntrega;

    private int partoDias;
    private int partoSemanas;
    private int intervalorGestacional;
}
























