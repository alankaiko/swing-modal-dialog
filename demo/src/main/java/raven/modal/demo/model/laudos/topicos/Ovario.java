package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Ovario extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumPosicaoOvario enumPosicaoOvario;

    @Enumerated(EnumType.STRING)
    private EnumRegular enumContorno;

    @Enumerated(EnumType.STRING)
    private EnumLimite enumLimite;

    @Enumerated(EnumType.STRING)
    private EnumParenquima enumParenquima;

    @Enumerated(EnumType.STRING)
    private EnumSuperficie enumSuperficie;

    @Enumerated(EnumType.STRING)
    private EnumMicropolicistica enumMicropolicistica;

    @Enumerated(EnumType.STRING)
    private EnumMobilidade enumMobilidade;

    @Enumerated(EnumType.STRING)
    private EnumAderido enumAderido;

    private float diametrol;
    private float diametroap;
    private float diametrot;
    private float volume;

    private Integer numerofoliculos;

    @Enumerated(EnumType.STRING)
    private EnumSimNao utilizartabela;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_massa_anexial_id", referencedColumnName = "codigo")
    private MassaAnexial massaAnexial;
}
