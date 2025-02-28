package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumCategoriaBosniak;

import javax.persistence.*;

@Getter
@Setter
@Table
@Entity
public class Cisto extends AbstractEntity {
    private float altura;
    private float largura;
    private float profundidade;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private EnumCategoriaBosniak enumCategoriaBosniak;

    @Column(length = 1000)
    private String texto;
}
