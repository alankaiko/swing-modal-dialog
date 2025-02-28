package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "imagemimpressa")
public class ImagemImpressa extends AbstractEntity {
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_imagem_id", referencedColumnName = "codigo")
    private Imagem imagem;

    private int indice;

    @Column(length = 1000)
    private String descricaoImagem;
}
