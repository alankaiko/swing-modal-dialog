package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "tiposenhaatendimento")
public class TipoSenhaAtendimento extends AbstractEntity {
    private String abreviacao;

    private String titulo;

    private String descricao;

    @ManyToMany
    @JoinTable(
            name = "tbl_tipo_senha_unidades",
            joinColumns = @JoinColumn(name = "tbl_tipo_senha_id"),
            inverseJoinColumns = @JoinColumn(name = "tbl_unidade_id"))
    private List<UnidadeComp> unidades;
}






































