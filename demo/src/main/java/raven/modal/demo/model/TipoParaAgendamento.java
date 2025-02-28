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
@Entity
@Table(name = "tipoparaagendamento")
public class TipoParaAgendamento extends AbstractEntity {
    private String titulo;
    private String descricao;

    @OneToOne
    @JoinColumn(name = "tbl_grupo_id", referencedColumnName = "codigo")
    private GrupoAtendimento grupo;
}
