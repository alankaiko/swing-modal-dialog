package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class Cliente extends AbstractEntity {
    private String nome;
    private String cpf;
    private String rg;
    private int idade;

    private LocalDate datanascimento;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_conjugue_id", referencedColumnName = "codigo")
    private Conjugue conjugue;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_criado_id", referencedColumnName = "codigo")
    private Usuario criadopor;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_desativado_id", referencedColumnName = "codigo")
    private Usuario desativadopor;
}
