package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.CID_CAUSA_OBITO;
import raven.modal.demo.model.enuns.CID_CLASSIFICACAO;
import raven.modal.demo.model.enuns.RESTRICAO_SEXO;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "subcategoriacid10")
public class SubcategoriaCID10 extends AbstractEntity {

    private String codigotabela;

    @ManyToOne
    @JoinColumn(name = "categoriacid10_codigo", referencedColumnName = "codigotabela")
    private CategoriaCID10 categoriaCID10;

    @Column(length = 500)
    private String nome;

    @Column(name = "nome50", length = 50)
    private String nome50;

    @Enumerated(EnumType.STRING)
    @Column(name = "classificacao")
    private CID_CLASSIFICACAO classificacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "restrsexo")
    private RESTRICAO_SEXO restrSexo;

    @Enumerated(EnumType.STRING)
    @Column(name = "causaobito")
    private CID_CAUSA_OBITO causaObito;

    @Column(name = "referencia")
    private String referencia;

    @Column(name = "excluidos")
    private String excluidos;
}
