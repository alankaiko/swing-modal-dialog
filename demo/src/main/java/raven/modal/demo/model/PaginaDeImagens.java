package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.LAYOUT_IMG;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "paginadeimagens")
public class PaginaDeImagens extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "layout")
    private LAYOUT_IMG layout;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ImagemImpressa> imagemimpressa;
}

