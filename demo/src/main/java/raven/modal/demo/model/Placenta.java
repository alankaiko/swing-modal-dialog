package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumInsercaoPlacenta1;
import raven.modal.demo.model.enuns.EnumInsercaoPlacenta2;
import raven.modal.demo.model.enuns.EnumMaturidade;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Placenta extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumInsercaoPlacenta1 insercao1;

    @Enumerated(EnumType.STRING)
    private EnumInsercaoPlacenta2 insercao2;
    private int espessura;

    @Enumerated(EnumType.STRING)
    private EnumMaturidade maturidade;

    @Column(length = 500)
    private String descricao;
}
