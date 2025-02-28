package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "examesagrupado")
public class ExamesAgrupado extends AbstractEntity {
    private String tituloAgrupado;

    @OneToOne
    @JoinColumn(name = "tbl_profissional_id", referencedColumnName = "codigo")
    private Profissional profissional;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ExameItem> exameItems;
}
