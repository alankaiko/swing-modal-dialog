package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "medicamentoprocedimento")
public class MedicamentoProcedimento extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "tbl_medicamento_id", referencedColumnName = "codigo")
    private Medicamento medicamento;

    private BigDecimal valorInformado;

    private int quantidade;
}
