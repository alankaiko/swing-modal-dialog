package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "amostradia")
public class AmostraDia extends AbstractEntity {
    private String amostra;
    private String preparo;
    private String meio;

    private String totalinicialvalor;
    private String totalinicialresultado;

    private String moveistrvalor;
    private String moveistrresultado;

    private String moveistlvalor;
    private String moveistlresultado;

    private String moveissituvalor;
    private String moveissituresultado;

    private String imoveisvalor;
    private String imoveisresultado;

    private String morfologiaresultado;

    private String volumevalor;

    private String totalpalhetasvalor;

    private LocalDate datacongelamento;
}
