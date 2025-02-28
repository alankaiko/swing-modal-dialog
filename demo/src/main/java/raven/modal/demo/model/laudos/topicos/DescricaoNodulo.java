package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumNodulos;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "descricaonodulo")
public class DescricaoNodulo extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumNodulos enumNodulos;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Nodulo> nodulos;

    @Column(length = 500)
    private String texto;
}
