package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumLabelCores;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tipodoatendimento")
public class TipodoAtendimento extends AbstractEntity {
    private String tipoatendimento;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "tbl_grupo_id", referencedColumnName = "codigo")
    private GrupoAtendimento grupo;
    private boolean ativo;

    @Enumerated(EnumType.STRING)
    private EnumLabelCores cor;
}
