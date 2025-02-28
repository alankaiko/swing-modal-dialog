package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumReceitaDespesa;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "grupodespesareceita")
public class GrupoDespesaReceita extends AbstractEntity {
    private String nome;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private EnumReceitaDespesa enumgrupo;
}
