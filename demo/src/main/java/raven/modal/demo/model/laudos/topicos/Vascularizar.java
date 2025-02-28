package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumRazaoVascular;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Vascularizar extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumRazaoVascular enumRazaoVascular;

    private String razaoDescrito;

    private float arteriaIrDireito;
    private float picoSistolicoDireito;
    private float arteriaIrEsquerdo;
    private float picoSistolicoEsquerdo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<NoduloTireoide> nodulosTireoides;

    @Enumerated(EnumType.STRING)
    private EnumSimNao descricaoNodulo;

    @Column(length = 500)
    private String texto;

}
