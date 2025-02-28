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
@Table
public class Vale extends AbstractEntity {
    private String numerolancamento;
    private String numerovale;
    private String informacoes;

    @OneToOne
    @JoinColumn(name = "tbl_profissional_id", referencedColumnName = "codigo")
    private Profissional profissional;

    private LocalDate datapagamento;
    private double valor;
    private int status;
}
