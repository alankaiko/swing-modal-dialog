package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "itemvinculado")
public class ItemVinculado extends AbstractEntity {

    private Integer posicao;

    private String descricao;

    private String descricaoPai;

    private Boolean possuiFilhos;
}
