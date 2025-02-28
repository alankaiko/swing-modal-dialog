package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "grupoprocedimento")
public class GrupoProcedimento extends AbstractEntity {
    private String titulo;

    @Column(length = 3)
    private String sigla;
}
