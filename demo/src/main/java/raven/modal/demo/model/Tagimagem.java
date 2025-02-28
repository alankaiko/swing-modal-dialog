package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table
@Entity
public class Tagimagem extends AbstractEntity {
    @Column(length = 300)
    private String imagetype;

    @Column(length = 300)
    private String sopclassuid;

    @Column(length = 300)
    private String sopinstanceuid;

    @Column(length = 300)
    private String studydate;

    @Column(length = 300)
    private String seriesdate;

    @Column(length = 300)
    private String acquisitiondate;

    @Column(length = 300)
    private String contentdate;

    @Column(length = 300)
    private String studytime;

    @Column(length = 300)
    private String seriestime;

    @Column(length = 300)
    private String acquisitiontime;

    @Column(length = 300)
    private String contenttime;

    @Column(length = 300)
    private String accessionnumber;

    @Column(length = 300)
    private String modality;

    @Column(length = 300)
    private String presentationintenttype;

    @Column(length = 300)
    private String manufacturer;

    @Column(length = 300)
    private String institutionname;

    @Column(length = 300)
    private String institutionaddress;

    @Column(length = 300)
    private String referringphysiciansname;

    @Column(length = 300)
    private String stationname;

    @Column(length = 300)
    private String studydescription;

    @Column(length = 300)
    private String seriesdescription;

    @Column(length = 300)
    private String institutionaldepartmentname;

    @Column(length = 300)
    private String performingphysiciansname;

    @Column(length = 300)
    private String operatorsname;

    @Column(length = 300)
    private String manufacturersmodelname;

    @Column(length = 300)
    private String referencedpatientsequence;

    @Column(length = 300)
    private String anatomicregionsequence;

    @Column(length = 300)
    private String primaryAnatomicstructuresequence;

    @Column(length = 300)
    private String patientsname;

    @Column(length = 300)
    private String patientid;

    @Column(length = 300)
    private String softwareversions;

    @Column(length = 300)
    private String imagerpixelspacing;

    @Column(length = 300)
    private String positionertype;

    @Column(length = 300)
    private String detectortype;

    @Column(length = 300)
    private String detectordescription;

    @Column(length = 300)
    private String detectormode;

    @Column(length = 300)
    private String timeoflastdetectorcalibration;

    @Column(length = 300)
    private String samplesperpixel;

    @Column(length = 300)
    private String photometricinterpretation;

    @Column(length = 300)
    private String rows;

    @Column(length = 300)
    private String columns;
}
