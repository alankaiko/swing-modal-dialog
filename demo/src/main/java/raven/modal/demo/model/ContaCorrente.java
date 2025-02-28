package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "contacorrente")
public class ContaCorrente extends AbstractEntity {
    private String numeroconta;
    private String descricao;
}
