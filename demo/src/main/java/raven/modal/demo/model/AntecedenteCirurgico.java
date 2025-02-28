package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "antecedentecirurgico")
public class AntecedenteCirurgico extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumSimNao vasectomia;
    private int vasectomiatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao reversaovasectomia;
    private int reversaovasectmoiatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao varicocele;
    private int varicoceletexto;

    @Column(length = 1000)
    private String outros;
}

















