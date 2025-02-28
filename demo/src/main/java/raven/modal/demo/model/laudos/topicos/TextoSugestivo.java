package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumTextoSugestivo;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "textosugestivo")
public class TextoSugestivo extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumTextoSugestivo enumTextoSugestivo;

    @Column(length = 1000)
    private String descricao;
}
