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
@Table
public class Cidade extends AbstractEntity {
    @Column(length = 2)
    private String abrevEstado;

    @Column(length = 35)
    private String estado;

    @Column(length = 80)
    private String cidade;
}
