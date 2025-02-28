package raven.modal.demo.model.laudos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.ProcedimentoAtendimento;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Table
@Entity
public class SwinUp extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "tbl_procedimento_atendimento_id", referencedColumnName = "codigo")
    private ProcedimentoAtendimento procedimentoAtendimento;

    private Double translativosRapidosSwinUp;
    private Double translativosLentosSwinUp;
    private Double situSwinUp;
    private Double imoveisSituSwinUp;
}
