package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "checklistsemenfinanceiro")
public class CheckListSemenFinanceiro extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumSimNao congelamentoRealizado;

    private LocalDate congelamentoRealizadoData;

    @Enumerated(EnumType.STRING)
    private EnumSimNao pagamentoEfetuado;

    private LocalDate pagamentoEfetuadoData;

    @Enumerated(EnumType.STRING)
    private EnumSimNao inadimplenteDesde;

    private LocalDate inadimplenteDesdeData;

    @Enumerated(EnumType.STRING)
    private EnumSimNao nomeSpc;

    private LocalDate nomeSpcData;

    @Enumerated(EnumType.STRING)
    private EnumSimNao avisoDescongelamento;

    private LocalDate avisoDescongelamentoData;

    @Column(length = 2000)
    private String observacao;
}
