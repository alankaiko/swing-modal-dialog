package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table
public class Conjugue extends AbstractEntity {
    private String nome;
    private String cpf;

    private Date datanascimento;
    private int idade;
    private String telefone;
    private String celular;
    private String email;
    private String profissao;
}
