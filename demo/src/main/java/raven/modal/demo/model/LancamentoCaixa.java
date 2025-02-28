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
@Table(name = "lancamentocaixa")
public class LancamentoCaixa extends AbstractEntity {
    private Long numerolancamento;

    @OneToOne
    @JoinColumn(name = "tbl_profissional_id", referencedColumnName = "codigo")
    private Paciente paciente;

    private LocalDate datalancamento;

    @OneToOne
    @JoinColumn(name = "tbl_caixa_id", referencedColumnName = "codigo")
    private Caixa caixa;
    private int notafiscal;
    private double valor;

    @OneToOne
    @JoinColumn(name = "tbl_conta_corrente_id", referencedColumnName = "codigo")
    private ContaCorrente contacorrente;
    private double retiradavales;
    private String historicovales;
    private int formapagamento;

    @OneToOne
    @JoinColumn(name = "tbl_banco_id", referencedColumnName = "codigo")
    private Banco banco;
    private String agencia;
    private String cheque;

    private LocalDate datachequepre;
}
