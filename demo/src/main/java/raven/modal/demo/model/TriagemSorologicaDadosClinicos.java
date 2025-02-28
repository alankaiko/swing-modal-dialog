package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumReagente;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "triagemsorologicadadosclinicos")
public class TriagemSorologicaDadosClinicos extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumReagente hiv;
    private String hivtexto;

    private LocalDate dataAdicao;

    @Enumerated(EnumType.STRING)
    private EnumReagente hsabg;
    private String hsabgtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente antihbcigg;
    private String antihbciggtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente hepatiteb;
    private String hepatitebtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente antihcvigm;
    private String antihcvigmtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente hepatitec;
    private String hepatitectexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente htlv;
    private String htlvtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente ftaabsigg;
    private String ftaabsiggtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente vdrl;
    private String vdrltexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente zikavirus;
    private String zikavirustexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente pcrhiv;
    private String pcrhivtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente pcrneisseria;
    private String pcrneisseriatexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente clamidiapcr;
    private String clamidiapcrtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente fatorabo;
    private String fatorabotexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente cariotipoeletroforese;
    private String cariotipoeletroforesetexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente hemoglobina;
    private String hemoglobinatexto;

    @Column(length = 16000)
    private String observacao;

    private String examePdf;
    private String exameNomePdf;
}
