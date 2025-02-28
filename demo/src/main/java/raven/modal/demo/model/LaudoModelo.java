package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "laudomodelo")
public class LaudoModelo extends AbstractEntity {
    @Column(length = 10000)
    private String texto;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Imagem> imagens;
}
