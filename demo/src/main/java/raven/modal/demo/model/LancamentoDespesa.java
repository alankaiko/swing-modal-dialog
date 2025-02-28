package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "lancamentodespesa")
public class LancamentoDespesa extends AbstractEntity {
    private Long codigo;
    private Long numerolancamento;

    @OneToOne
    @JoinColumn(name = "tbl_caixa_id", referencedColumnName = "codigo")
    private Caixa caixa;

    private LocalDate datalancamento;
    private String historico;
    private double valor;

    @OneToOne
    @JoinColumn(name = "tbl_grupo_despesa_receita_id", referencedColumnName = "codigo")
    private GrupoDespesaReceita grupo;
    private int auto;
}
