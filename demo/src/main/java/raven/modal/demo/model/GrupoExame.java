package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "grupoexame")
public class GrupoExame extends AbstractEntity {
    private String titulo;
    private String descricao;
}
