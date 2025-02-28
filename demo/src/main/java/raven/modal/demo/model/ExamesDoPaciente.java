package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumGrupoSanguineo;
import raven.modal.demo.model.enuns.EnumReagente;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "examesdopaciente")
public class ExamesDoPaciente extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;
    private String peso;
    private String altura;
    private String imc;

    @Enumerated(EnumType.STRING)
    private EnumGrupoSanguineo gruposanguineo;

    @Enumerated(EnumType.STRING)
    private EnumReagente hiv;
    private String hivtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente hsabg;
    private String hsabgtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente antihbcige;
    private String antihbcigetexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente antihbcigm;
    private String antihbcigmtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente antihbs;
    private String antihbstexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente antihcv;
    private String antihcvtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente htlv;
    private String htlvtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente vdrl;
    private String vdrltexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente ftaabsige;
    private String ftaabsigetexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente ftaabsigm;
    private String ftaabsigmtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente zikavirus;
    private String zikavirustexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente clamidiapcr;
    private String clamidiapcrtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente pcrneisseria;
    private String pcrneisseriatexto;
}
