package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Table
@Entity
public class Exame extends AbstractEntity {
    private String codigoabrev;
    private String titulo;
    private String descricao;

    @OneToOne
    @JoinColumn(name = "tbl_grupoexame_id", referencedColumnName = "codigo")
    private GrupoExame grupoexame;

    private Integer posicao;
}
