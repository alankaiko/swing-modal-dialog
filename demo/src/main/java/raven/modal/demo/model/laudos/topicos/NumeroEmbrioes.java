package raven.modal.demo.model.laudos.topicos;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "numeroembrioes")
public class NumeroEmbrioes extends AbstractEntity {
    private int qtdEmbrioes;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DimensoesEmbriao> dimensoesEmbriaos;

    @Column(length = 500)
    private String texto;

    private int idadeSemanas;

    private int idadeDias;

    private LocalDate dpp;
}