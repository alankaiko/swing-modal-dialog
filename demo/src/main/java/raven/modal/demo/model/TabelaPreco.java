package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "tabelapreco")
public class TabelaPreco extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "tbl_convenio_id", referencedColumnName = "codigo")
    private Convenio convenio;

    private BigDecimal valorconvenio;
}
