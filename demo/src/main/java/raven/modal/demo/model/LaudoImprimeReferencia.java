package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumLaudoPadraoIdadeGestacao;
import raven.modal.demo.model.enuns.EnumLaudoReferencia;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "laudoimprimereferencia")
public class LaudoImprimeReferencia extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumLaudoReferencia referencia;

    @Enumerated(EnumType.STRING)
    private EnumLaudoPadraoIdadeGestacao padrao;
    private float semana;
}
