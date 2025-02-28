package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumCariotipo;
import raven.modal.demo.model.enuns.EnumReagente;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "doadorexame")
public class DoadorExame extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "tbl_ficha_doador_id", referencedColumnName = "codigo")
    private FichaDoador fichadoador;

    private String registro;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_conjugue_id", referencedColumnName = "codigo")
    private Conjugue conjugue;

    @Embedded
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private EnumReagente hiv;
    private String hivtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente hbv;
    private String hbvtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente hcv;
    private String hcvtexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente hsabg;

    @Enumerated(EnumType.STRING)
    private EnumReagente antihbcige;

    @Enumerated(EnumType.STRING)
    private EnumReagente antihbcigm;

    @Enumerated(EnumType.STRING)
    private EnumReagente antihbcigg;

    @Enumerated(EnumType.STRING)
    private EnumReagente antihbs;

    @Enumerated(EnumType.STRING)
    private EnumReagente antihcv;

    @Enumerated(EnumType.STRING)
    private EnumReagente htlv;

    @Enumerated(EnumType.STRING)
    private EnumReagente vdrl;

    @Enumerated(EnumType.STRING)
    private EnumReagente ftaabsige;

    @Enumerated(EnumType.STRING)
    private EnumReagente ftaabsigm;

    @Enumerated(EnumType.STRING)
    private EnumReagente zikavirus;

    private String zikavirustexto;

    @Enumerated(EnumType.STRING)
    private EnumReagente zikavirusigm;

    private String zikavirustextoigm;

    @Enumerated(EnumType.STRING)
    private EnumReagente clamidiapcr;

    @Enumerated(EnumType.STRING)
    private EnumReagente pcrneisseria;
    private String pcrneisseriatexto;

    @Enumerated(EnumType.STRING)
    private EnumCariotipo cariotipo;

    private String cariotipotexto;
    private String a1;
    private String a2;
    private String fetal;
    private String hemoglobinas;
    private String hemoglobinac;
    private String eletroforeseoutras;
    private String concentracao;
    private String progressivos;
    private String normais;

    @Enumerated(EnumType.STRING)
    private EnumSimNao epilepsia;

    @Enumerated(EnumType.STRING)
    private EnumSimNao hemofilia;

    @Enumerated(EnumType.STRING)
    private EnumSimNao neurofibromatose;

    @Enumerated(EnumType.STRING)
    private EnumSimNao doencacoronariana;

    @Enumerated(EnumType.STRING)
    private EnumSimNao neoplasias;

    @Enumerated(EnumType.STRING)
    private EnumSimNao psicose;

    @Enumerated(EnumType.STRING)
    private EnumSimNao albinismo;

    @Enumerated(EnumType.STRING)
    private EnumSimNao asma;

    @Enumerated(EnumType.STRING)
    private EnumSimNao esclerose;

    @Enumerated(EnumType.STRING)
    private EnumSimNao artritereumatoide;

    @Enumerated(EnumType.STRING)
    private EnumSimNao diabetesjuvenis;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_pre_congelamento_id", referencedColumnName = "codigo")
    private ExameAvaliacao precongelamento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_armazenamento_id", referencedColumnName = "codigo")
    private ExameArmazenamento armazenamentoamostra;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_pos_congelamento_id", referencedColumnName = "codigo")
    private ExameAvaliacao poscongelamento;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ExameSaidaAmostra> saidaamostras;

    private String nomePdf;
    private String caminhoPdf;
}
