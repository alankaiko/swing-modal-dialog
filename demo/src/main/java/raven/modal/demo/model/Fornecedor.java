package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Table
@Entity
public class Fornecedor extends AbstractEntity {
    private String nome;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;
    private String nomecontato;
    private String tipo;
    private LocalDate dataultimacompra;
    private String valorultimacompra;
    private String codcontaprincipal;
    private String codcontasecundaria;
    private String descricaolancamento;
    private String cnpj;
    private String observacao;
}
