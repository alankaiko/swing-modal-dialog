package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumDestino;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "checklistsemenembriao")
public class CheckListSemenEmbriao extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumDestino destino;

    @Column(length = 2000)
    private String observacao;
}
