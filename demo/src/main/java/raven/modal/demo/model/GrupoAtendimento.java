package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "grupoatendimento")
public class GrupoAtendimento extends AbstractEntity {
    private String nome;
    private String descricao;
    private boolean ativo;
}
