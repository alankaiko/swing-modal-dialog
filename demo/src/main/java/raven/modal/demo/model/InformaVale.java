package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "informavale")
public class InformaVale extends AbstractEntity {
    private String numerolancamento;
    private String numerovale;
    private String informacoes;

    private LocalDate datapagamento;
    private double valor;
    private int status;
}
