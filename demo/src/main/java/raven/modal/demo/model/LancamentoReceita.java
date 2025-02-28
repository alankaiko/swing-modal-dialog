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
@Table(name = "lancamentoreceita")
public class LancamentoReceita extends AbstractEntity {
    private Long numerolancamento;

    @OneToOne
    @JoinColumn(name = "tbl_caixa_id", referencedColumnName = "codigo")
    private Caixa caixa;

    private LocalDate datalancamento;
    private String historico;

    @OneToOne
    @JoinColumn(name = "tbl_grupo_id", referencedColumnName = "codigo")
    private GrupoDespesaReceita grupo;
    private double valor;
    private int auto;
}
