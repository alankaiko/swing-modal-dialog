package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "massaanexial")
public class MassaAnexial extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumSimNao simNao;

    @Enumerated(EnumType.STRING)
    private EnumSimNao cancer;

    @Enumerated(EnumType.STRING)
    private EnumSimNao terapiaHormonal;

    @Enumerated(EnumType.STRING)
    private EnumSimNao dorDuranteExame;

    @Enumerated(EnumType.STRING)
    private EnumSimNao ascites;

    private Integer quantidadeEncontrada;

    @OneToMany(cascade = CascadeType.ALL)
    List<MassaAnexialEncontrada> massaAnexialEncontradas;
}
