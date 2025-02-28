package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "itemchecado")
public class ItemChecado extends AbstractEntity {
    private String titulo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<TopicoChecado> topicoChecados;

    private Integer posicaoItem;

    private Date dataHoraRegistrada;
}
