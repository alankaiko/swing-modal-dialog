package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumLaudoPosicaoOvario;
import raven.modal.demo.model.enuns.EnumLimite;
import raven.modal.demo.model.enuns.EnumParenquima;
import raven.modal.demo.model.enuns.EnumRegular;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "laudoovario")
public class LaudoOvario extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumLaudoPosicaoOvario posicao;

    @Enumerated(EnumType.STRING)
    private EnumLimite limites;
    private float diametrol;
    private float diametroap;
    private float diametrot;

    @Enumerated(EnumType.STRING)
    private EnumRegular contorno;

    @Enumerated(EnumType.STRING)
    private EnumParenquima parenquima;

    @Column(length = 500)
    private String descricao;
}
