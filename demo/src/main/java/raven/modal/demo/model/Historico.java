package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Historico extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;

    @Enumerated(EnumType.STRING)
    private EnumSimNao herpes;
    private String herpestexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao herpeszoster;
    private String herpeszostertexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao lupus;
    private String lupustexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao hepatite;
    private String hepatitetexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao condiloma;
    private String condilomatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao cancer;
    private String cancertexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao labioliporino;
    private String labioliporinotexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao luxacaocongeninta;
    private String luxacaocongenintatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao alergia;
    private String alergiatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao doencasconhecidas;
    private String doencasconhecidastexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao espinhabifida;
    private String espinhabifidatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao fumante;
    private String fumantetexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao malformacao;
    private String malformacaotexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao asma;
    private String asmatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao psicose;
    private String psicosetexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao neoplasias;
    private String neoplasiastexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao albinismo;
    private String albinismotexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao esclerose;
    private String esclerosetexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao diabetesjuvenis;
    private String diabetesjuvenistexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao artritereumatoide;
    private String artritereumatoidetexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao hemofilia;
    private String hemofiliatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao epilepsia;
    private String epilepsiatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao doencacoronariana;
    private String doencacoronarianatexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao neurofibromatose;
    private String neurofibromatosetexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao infartomiocardio;
    private String infartomiocardiotexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao hipertensao;
    private String hipertensaotexto;
}
