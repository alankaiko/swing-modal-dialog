package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumEstado;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tissconselho")
public class TISSConselho extends AbstractEntity {
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "tbl_sigla_id", referencedColumnName = "codigo")
    private Sigla sigla;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private EnumEstado estado;
}
