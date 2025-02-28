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
@Table
public class Banco extends AbstractEntity {
    private String nome;

    private LocalDate datacadastro;
    private String numerobanco;
}
