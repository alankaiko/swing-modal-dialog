package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumTempoEvolucao;
import raven.modal.demo.model.enuns.EnumTipoDoenca;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "diagnosticoguia")
public class DiagnosticoGuia extends AbstractEntity {
    private String tabelaCid;

    private String numeroCid;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private EnumTipoDoenca enumTipoDoenca;

    @Enumerated(EnumType.STRING)
    private EnumTempoEvolucao enumTempoEvolucao;

    private Integer indicadorAcidente;
}
