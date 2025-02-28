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
@Table(name = "tratamentogravidez")
public class TratamentoGravidez extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumSimNao espontanea;

    @Enumerated(EnumType.STRING)
    private EnumSimNao endometriose;
    private String endometriosetexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao coito;
    private String coitotexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao proprioSemem;

    @Enumerated(EnumType.STRING)
    private EnumSimNao doadorSemem;

    @Enumerated(EnumType.STRING)
    private EnumSimNao programafiv;
    private String programafivtexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao congelado;
    private String congeladotexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao receptoraOvulo;
    private String receptoraovulotexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao receptoraEmbriao;
    private String receptoraembriaotexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao vasectomia;

    @Enumerated(EnumType.STRING)
    private EnumSimNao tratamentoendo;
    private String tratamentoendotexto;

    @Enumerated(EnumType.STRING)
    private EnumSimNao cicloCancelado;

    @Enumerated(EnumType.STRING)
    private EnumSimNao inseminacao;
    private String inseminacaotexto;
}

















