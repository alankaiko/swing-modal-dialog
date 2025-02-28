package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumEstadoCivil;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class Doador extends AbstractEntity {
    private String cpf;

    private LocalDate datanascimento;

    @Embedded
    private Contato contato;
    private int idade;
    private String nome;

    @Enumerated(EnumType.STRING)
    private EnumEstadoCivil estadocivil;
}
