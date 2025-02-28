package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSexo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Profissional extends AbstractEntity implements Comparable<Profissional> {
    private Long codigoexaminador;

    @Column(nullable = false)
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_conselho_id", referencedColumnName = "codigo")
    private TISSConselho conselho;

    @OneToOne
    @JoinColumn(name = "tbl_especialidade_id", referencedColumnName = "codigo")
    private EspecialidadeDoProfissional especialidade;
    private String observacao;

    //@JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "tbl_medico_unidades",
            joinColumns = @JoinColumn(name = "tbl_profissional_id"),
            inverseJoinColumns = @JoinColumn(name = "tbl_unidade_id"))
    private List<UnidadeComp> unidades;
    private boolean desativado;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_criado_id", referencedColumnName = "codigo")
    private Usuario criadopor;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_desativado_id", referencedColumnName = "codigo")
    private Usuario desativadopor;

    private String uuid;

    private String cpf;

    private Boolean usarImagem;

    private String caminhoImagem;

    private String nomeImagem;

    private Boolean integradoMemed;

    private String token;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_vinculado_id", referencedColumnName = "codigo")
    private Usuario usuarioVinculado;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;

    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private EnumSexo sexo;

    @Override
    public int compareTo(Profissional outro) {
        return this.getCodigo().compareTo(outro.getCodigo());
    }
}
