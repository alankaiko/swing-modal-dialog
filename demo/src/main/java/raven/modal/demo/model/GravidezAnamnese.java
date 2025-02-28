package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "gravidezanamnese")
public class GravidezAnamnese extends AbstractEntity {
    private int anos;
    private int meses;
    private int gravidez;
    private int parto;
    private int aborto;
    private int partoNormal;
    private int cesariana;
    private int ectopica;
    private int cureta;
    private EnumSimNao laqueadura;
    private int ha;
    private EnumSimNao reltb;
    private EnumSimNao temFilhos;
    private int qtdFilhos;
    private int idadeinicio;
    private int idadefinal;
    private int filhosrelacionamentoanterior;
    private int filhosrelacionamentoatual;
}
