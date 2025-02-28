package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table
@Entity
public class Empresa extends AbstractEntity {
    private String titulo;
    private String razaosocial;
    private String nomefantasia;
    private String cnpj;
    private boolean ativo;
    private String observacoes;

    @Embedded
    private Contato contato;

    @Embedded
    private Endereco endereco;
}
