package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table
public class Equipamento extends AbstractEntity {
    @Column(length = 220)
    private String instituicao;
    private String endereco;

    @Column(length = 180)
    private String departamento;

    @Column(length = 165)
    private String nomemodality;

    @Column(length = 145)
    private String conversiontype;

    @Column(length = 230)
    private String fabricante;

    @Column(length = 230)
    private String modelo;

    @Column(length = 170)
    private String stationname;

    @Column(length = 200)
    private String serial;

    @Column(length = 200)
    private String softwareversion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datamodificacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datacriacao;

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        datamodificacao = new Date();

        if (datacriacao == null)
            datacriacao = new Date();
    }

}
