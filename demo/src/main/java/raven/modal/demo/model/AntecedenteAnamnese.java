package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "antecedenteanamnese")
public class AntecedenteAnamnese extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumSimNao antecedentecirurgico;
    private String antecedentecirurgicotexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao histeroscopia;

    @Enumerated(EnumType.STRING)
    private EnumSimNao laparoscopia;

    @Enumerated(EnumType.STRING)
    private EnumSimNao histerosalpingografia;

    @Enumerated(EnumType.STRING)
    private EnumSimNao endometriosepelvica;
    private String estadio;

    @Enumerated(EnumType.STRING)
    private EnumSimNao ovariodireito;

    @Enumerated(EnumType.STRING)
    private EnumSimNao ovarioesquerdo;

    @Enumerated(EnumType.STRING)
    private EnumSimNao ca125;
    private float ca125valor;

    @Enumerated(EnumType.STRING)
    private EnumSimNao achadosanormais;

    @Enumerated(EnumType.STRING)
    private EnumSimNao espermograma;
    private float quantidade;
    private float motilidade;

    @Enumerated(EnumType.STRING)
    private EnumSimNao fragmentacao;
    private float valor;

    @Enumerated(EnumType.STRING)
    private EnumSimNao filhosoutrosrelacionamento;
    private int numerofilhos;
    private int idadeinicio;
    private int idadefim;
}



















