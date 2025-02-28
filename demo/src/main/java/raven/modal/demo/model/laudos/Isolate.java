package raven.modal.demo.model.laudos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.ProcedimentoAtendimento;

import javax.persistence.*;

@Getter
@Setter
@Table
@Entity
public class Isolate extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "tbl_procedimento_atendimento_id", referencedColumnName = "codigo")
    private ProcedimentoAtendimento procedimentoAtendimento;

    private Double translativosRapidosIsolate;
    private Double translativosLentosIsolate;
    private Double situIsolate;
    private Double imoveisSituIsolate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_espermograma_id", referencedColumnName = "codigo")
    private Espermograma espermograma;
}
