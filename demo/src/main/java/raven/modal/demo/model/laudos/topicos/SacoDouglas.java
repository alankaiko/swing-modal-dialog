package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSacoDouglas;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "laudosacodouglas")
public class SacoDouglas extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumSacoDouglas enumSacoDouglas;

    @Column(length = 500)
    private String descricao;
}
