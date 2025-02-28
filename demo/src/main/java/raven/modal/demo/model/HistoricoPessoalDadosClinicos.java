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
@Table(name = "historicopessoaldadosclinicos")
public class HistoricoPessoalDadosClinicos extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumSimNao herpes;
    private String herpestexto;

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
    private EnumSimNao malformacao;
    private String malformacaotexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao hepatite;
    private String hepatitetexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao luxacaocongeninta;
    private String luxacaocongenintatexto;


    @Enumerated(EnumType.STRING)
    private EnumSimNao fumante;
    private String fumantetexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao doencasconhecidas;
    private String doencasconhecidastexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao alergia;
    private String alergiatexto;
}
