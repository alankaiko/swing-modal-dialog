package raven.modal.demo.model.laudos.topicos;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "dadosamenoexame")
public class DadosAmenoExame extends AbstractEntity {
    private LocalDate dum;
    private int semana;
    private int dias;

    private LocalDate dpp;

    private int ighSemana;
    private int ighDias;
}