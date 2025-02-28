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
@Table(name = "categoriacid10")
public class CategoriaCID10 extends AbstractEntity {

    private String codigotabela;

    @ManyToOne
    @JoinColumn(name = "grupocid10_codigo", referencedColumnName = "codigotabela")
    private GrupoCID10 grupoCID10;

    private String nome;
}
