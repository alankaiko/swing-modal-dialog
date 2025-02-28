package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumPresenca;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "cardiotocografiafetal")
public class CardiotocografiaFetal extends AbstractEntity {
    private double frequencia;
    private double variabilidade;

    @Enumerated(EnumType.STRING)
    private EnumPresenca aceleracao;

    @Enumerated(EnumType.STRING)
    private EnumPresenca desaceleracao;

    private double numeroAceleracao;

    @Enumerated(EnumType.STRING)
    private EnumSimNao estimulo;
}
