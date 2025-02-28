package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumMenstruacao;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ciclomenstrual")
public class CicloMenstrual extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumMenstruacao enumMenstruacao;

    private LocalDate dataultima;
    private int diaciclo;
    private Double peso;
    private Double altura;
    private String imc;
}
