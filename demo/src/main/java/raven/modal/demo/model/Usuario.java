package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Usuario extends AbstractEntity {
    private String nome;

    private String sobrenome;

    private String login;

    private String senha;

    private String teste;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_permissao", joinColumns = @JoinColumn(name = "codigo_usuario"),
            inverseJoinColumns = @JoinColumn(name = "codigo_permissao"))
    private List<Permissao> permissoes;

    @OneToOne
    @JoinColumn(name = "tbl_permissao_id", referencedColumnName = "codigo")
    private Permissao permissaoPrincipal;

    private Long idunidadeempresa;

    private Long idcompania;

    @OneToOne
    @JoinColumn(name = "tbl_unidade_id", referencedColumnName = "codigo")
    private UnidadeComp unidade;

    private Boolean ativo = false;
}
