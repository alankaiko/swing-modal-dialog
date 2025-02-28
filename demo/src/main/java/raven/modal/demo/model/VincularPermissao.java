package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "vincularpermissao")
public class VincularPermissao extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "tbl_permissaoo_id", referencedColumnName = "codigo")
    private Permissao permissao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemVinculado> itemVinculados;
}