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
@Table(name = "series")
public class Series extends AbstractEntity {
    @Column(length = 200)
    private String seriesinstanceuid;

    @Column(length = 200)
    private String seriesdescription;
    private Integer seriesnumber;

    @Column(length = 130)
    private String patientposition;

    @Column(length = 200)
    private String bodypartexamined;

    @Column(length = 140)
    private String laterality;

    @Column(length = 150)
    private String operatorsname;

    @Column(length = 200)
    private String protocolname;

    @Temporal(TemporalType.TIMESTAMP)
    private Date seriesdatetime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datacriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datamodificacao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Instancia> instancias;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_conselho_id", referencedColumnName = "codigo")
    private Equipamento equipamento;

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        datamodificacao = new Date();

        if (datacriacao == null)
            datacriacao = new Date();
    }
}
