package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumPermissao;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "gruposusuario")
public class GruposUsuario extends AbstractEntity {
    private String titulo;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private EnumPermissao permissao;
}
