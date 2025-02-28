package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumEvolucaoGravidez;
import raven.modal.demo.model.enuns.EnumSimNao;
import raven.modal.demo.model.enuns.EnumTipoGravidez;
import raven.modal.demo.model.enuns.EnumTipoParto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "resultadofinalprocedimento")
public class ResultadoFinalProcedimento extends AbstractEntity {
    private Integer numerosaco;

    @Enumerated(EnumType.STRING)
    private EnumTipoGravidez tipogravidez;

    @Enumerated(EnumType.STRING)
    private EnumEvolucaoGravidez evolucao;

    @Enumerated(EnumType.STRING)
    private EnumTipoParto tipoparto;
    private LocalDate dataparto;
    private Integer qtdsemanas;

    @Enumerated(EnumType.STRING)
    private EnumSimNao malformacao;
    private String malformacaotexto;
    private String intercorrencia;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Perinatal> resultados;
}
