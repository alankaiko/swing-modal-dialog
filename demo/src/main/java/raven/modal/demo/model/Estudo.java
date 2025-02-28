package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Estudo extends AbstractEntity {
    @Column(length = 150)
    private String accessionnumber;

    @Column(length = 160)
    private String studyid;

    @Column(length = 220)
    private String studyinstanceuid;

    @Column(length = 350)
    private String studydescription;

    @Temporal(TemporalType.TIMESTAMP)
    private Date studydatetime;

    @Column(length = 220)
    private String referringphysicianname;

    @Column(length = 180)
    private String studypriorityid;

    @Column(length = 180)
    private String studystatusid;

    @Column(length = 350)
    private String additionalpatienthistory;

    @Column(length = 250)
    private String admittingdiagnosesdescription;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datacriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datamodificacao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Series> series;


    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        datamodificacao = new Date();

        if (datacriacao == null)
            datacriacao = new Date();
    }
}
