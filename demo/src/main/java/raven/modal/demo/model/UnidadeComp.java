package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "unidadecomp")
public class UnidadeComp extends AbstractEntity {
    private String nomeunidade;

    private String descricao;

    private boolean ativocpf;

    private String cnpj;

    private String cpf;

    @Embedded
    private Contato contato;

    @Embedded
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "compania_codigo", referencedColumnName = "codigo", nullable = false)
    private Compania compania;

    private boolean ativo;

    private LocalDate dataencerramento;

    private Long unidadenumero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_profissional_id", referencedColumnName = "codigo")
    private Profissional profissional;

    private LocalDate dataalteracao;

    private Long codigousuarioultimaalteracao;
}
