package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "receitamedicamento")
public class ReceitaMedicamento extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "tbl_medicamento_id", referencedColumnName = "codigo")
    private Medicamento medicamento;
    private Long qtdcaixas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_receita_id", referencedColumnName = "codigo")
    private Receita receita;

    @Enumerated(EnumType.STRING)
    private EnumVerbo verbo;
    private String outroverbo;

    @Enumerated(EnumType.STRING)
    private EnumDose dose;
    private int outrodose;

    @Enumerated(EnumType.STRING)
    private EnumApresentacao apresentacao;
    private String outroapresentacao;

    @Enumerated(EnumType.STRING)
    private EnumComplemento complemento;
    private String outrocomplemento;

    @Enumerated(EnumType.STRING)
    private EnumFrequencia frequencia;
    private String outrofrequencia;

    @Enumerated(EnumType.STRING)
    private EnumDuracao duracao;
    private int duracaodurante;
    private String outroduracao;
}
