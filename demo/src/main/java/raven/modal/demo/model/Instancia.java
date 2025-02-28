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
public class Instancia extends AbstractEntity {
    private Integer instancenumber;

    @Column(length = 150)
    private String patientorientation;

    @Column(length = 210)
    private String mediastoragesopinstanceuid;

    @Column(length = 210)
    private String sopinstanceuid;

    @Column(length = 210)
    private String sopclassuid;

    @Column(length = 210)
    private String transfersyntaxuid;

    @Temporal(TemporalType.TIMESTAMP)
    private Date acquisitiondatetime;

    @Column(length = 160)
    private String imagetype;
    private Float pixelspacing;

    @Column(length = 160)
    private String imageorientation;
    private Integer xraytubecurrent;
    private Integer exposuretime;

    @Column(length = 160)
    private String kvp;
    private Float slicelocation;
    private Float slicethickness;

    @Column(length = 200)
    private String imageposition;

    @Column(length = 170)
    private String windowcenter;

    @Column(length = 170)
    private String windowwidth;

    @Temporal(TemporalType.TIMESTAMP)
    private Date contentdatetime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datacriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datamodificacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_tagimagem_id", referencedColumnName = "codigo")
    private Tagimagem tagimagem;

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        datamodificacao = new Date();

        if (datacriacao == null)
            datacriacao = new Date();
    }
}
