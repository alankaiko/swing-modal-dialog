package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table
public class Convenio extends AbstractEntity {
    private String nome;
    private boolean ativo = true;

    @Column(length = 500)
    private String observacoes;

    private Long codconvenio;
    private String statusconvenio;
    private String valorpagar;
    private String guia;
    private String fatormultiplicativo;
    private String tabelataxas;
    private String valorch;
    private String tabelamateriais;
    private String fatormultitaxas;
    private String fatormultimateriais;
    private String tabelausada;
    private String loteatual;
    private String cgc;
    private String endereco;
    private String usarpercenacomodsadt;
    private String chmedicamentos;
    private String chgases;
    private String contato;
    private String codigoconsulta;
    private String fones;
    private String usarpercenemergesadt;
    private String percentemergencia;
    private String valoruco;
    private String diaentrega;
    private String diapagamento;
    private String bancoconta;
    private String fatormedicamentos;
    private String fatorgases;
    private String prazopgto;
    private String chtaxas;
    private String chmatmed;
    private String percentanestesista1;
    private String percentanestesista2;
    private String percentanestesista3;
    private String moedaanestesista;
    private String valormoedaanestesist;
    private String casasdecimais;
    private String tabelamedicamento;
    private String tabelagases;
    private String tabelatiss1;
    private String tabelatiss2;
    private String tabelatiss3;
    private String tabelatiss4;
    private String tabelatiss5;
    private String camposobrigatorios;
    private String gerarguiasatdhono;
    private String versao;
    private String obrigalancarpgtodesp;
    private String filler1;
    private String participatiss;
}
