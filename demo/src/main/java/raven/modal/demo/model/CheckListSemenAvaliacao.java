package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "checklistsemenavaliacao")
public class CheckListSemenAvaliacao extends AbstractEntity {
    private String nomeMedico;

    private Integer notaMedico;

    private LocalDate dataAvaliacaoMedico;

    @Column(length = 400)
    private String observacaoMedico;

    private String nomeEnfermeira;

    private Integer notaEnfermeira;

    private LocalDate dataAvaliacaoEnfermeira;

    @Column(length = 400)
    private String observacaoEnfermeira;

    private String nomeBiomedico;

    private Integer notaBiomedico;

    private LocalDate dataAvaliacaoBiomedico;

    @Column(length = 400)
    private String observacaoBiomedico;

    private String nomeFinanceiro;

    private Integer notaFinanceiro;

    private LocalDate dataAvaliacaoFinanceiro;

    @Column(length = 400)
    private String observacaoFinanceiro;
}
