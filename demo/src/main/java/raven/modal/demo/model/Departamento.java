package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Table
@Entity
public class Departamento extends AbstractEntity {
    @Column(length = 70)
    private String nome;

    @Column(length = 200)
    private String descricao;
    private String senha;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "unidade_codigo", referencedColumnName = "codigo", nullable = false)
    private UnidadeComp unidade;

    private LocalDate dataalteracao;
    private Long codigousuarioultimaalteracao;
}
