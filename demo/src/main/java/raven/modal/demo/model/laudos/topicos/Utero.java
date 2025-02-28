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
public class Utero extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumSituacao enumSituacao;

    @Enumerated(EnumType.STRING)
    private EnumRegular enumContorno;

    @Enumerated(EnumType.STRING)
    private EnumPosicao enumPosicao;

    @Enumerated(EnumType.STRING)
    private EnumLimite enumLimite;

    private float diametrol;
    private float diametroap;
    private float diametrot;
    private float volume;

    @Enumerated(EnumType.STRING)
    private EnumTexturaMiometro enumTexturaMiometro;

    @Enumerated(EnumType.STRING)
    private EnumCanalEndocervical enumCanalEndocervical;

    @Enumerated(EnumType.STRING)
    private EnumMiometriais enumMiometriais;

    @Enumerated(EnumType.STRING)
    private EnumZonaJuncional enumZonaJuncional;

    @Enumerated(EnumType.STRING)
    private EnumMobilidade enumMobilidade;

    @Enumerated(EnumType.STRING)
    private EnumAderido enumAderido;

    @Enumerated(EnumType.STRING)
    private EnumInformado coloUterino;

    private float medidaColoUterino;

    @Column(length = 1000)
    private String descricao;
}
