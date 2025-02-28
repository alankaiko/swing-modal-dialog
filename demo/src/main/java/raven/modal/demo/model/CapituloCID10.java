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
@Table(name = "capitulocid10")
public class CapituloCID10 extends AbstractEntity {

    private String codigotabela;

    @Column(length = 150)
    private String nome;
}
