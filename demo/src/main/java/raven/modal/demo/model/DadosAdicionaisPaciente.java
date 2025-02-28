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
@Table(name = "dadosadicionaispaciente")
public class DadosAdicionaisPaciente extends AbstractEntity {
    private LocalDate dtretorno;
    private LocalDate datanascimento;
    private String nomefonetico;
    private String procedencia;
    private String naturalidade;
    private String temlembrete;
    private String temobs;
    private String medico;
    private String nomeusrmedico;
    private String foneindicacao;
    private String codconvenio;
    private String valorpagar;
    private String valorpago;
    private String horamarcada;
    private String nvisitas;
    private String ultimoatendimento;
    private String tipofoneadicional;
    private String recadocom;
    private String pacienteinternado;
    private String temfoto;
    private String teminfoclinicas;
    private String codigoprimeiromedico;
    private String especialidadeficha;
    private String fotoficha;
    private String ultimaalteracao;
    private String statusfinanceiro;
    private String anonascimento;
    private String mesdianascimento;
    private LocalDate dtultimaconsulta;
    private String tipofone;
    private String codpaciente;
    private String enviarmaladireta;
}
