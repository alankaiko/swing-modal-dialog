package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "checklistsemenfamilia")
public class CheckListSemenFamilia extends AbstractEntity {
    @OneToMany(cascade = CascadeType.ALL)
    private List<CheckListFilho> filho;

    @Enumerated(EnumType.STRING)
    private EnumSimNao maisFilho;

    @Column(length = 2000)
    private String observacao;
}
