package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "historicofamiliardadosclinicos")
public class HistoricoFamiliarDadosClinicos extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumSimNao asma;
    private String asmatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao epilepsia;
    private String epilepsiatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao artritereumatoide;
    private String artritereumatoidetexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao neoplasias;
    private String neoplasiastexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao albinismo;
    private String albinismotexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao neurofibromatose;
    private String neurofibromatosetexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao diabetesjuvenis;
    private String diabetesjuvenistexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao psicose;
    private String psicosetexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao doencacoronariana;
    private String doencacoronarianatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao hemofilia;
    private String hemofiliatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao esclerose;
    private String esclerosetexto;


}
