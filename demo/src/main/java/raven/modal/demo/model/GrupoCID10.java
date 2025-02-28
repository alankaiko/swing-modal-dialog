package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "grupocid10")
public class GrupoCID10 extends AbstractEntity {

    private String codigotabela;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "capitulocid10_codigo", referencedColumnName = "codigotabela")
    private CapituloCID10 capituloCID10;
}
