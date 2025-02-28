package raven.modal.demo.model.laudos.topicos;



import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.Placenta;
import raven.modal.demo.model.enuns.EnumCrescimento;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "dimensoesembriao")
public class DimensoesEmbriao extends AbstractEntity {
    private Float dimensao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_numero_embrioes_id", referencedColumnName = "codigo")
    private SacoGestacional sacoGestacional;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_feto_id", referencedColumnName = "codigo")
    private Feto feto;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_placenta_id", referencedColumnName = "codigo")
    private Placenta placenta;

    private Float dbp;
    private String dbpMedia;
    private String dbpMedidas;

    private Float dof;
    private String dofMedia;
    private String dofMedidas;

    private Float dap;
    private String dapMedia;
    private String dapMedidas;

    private Float dll;
    private String dllMedia;
    private String dllMedidas;

    private Float ca;
    private String caMedia;
    private String caMedidas;

    private Float cf;
    private Float cfEsquerdo;
    private String cfMedia;
    private String cfMedidas;

    private Float umero;
    private Float umeroEsquerdo;
    private String umeroMedia;
    private String umeroMedidas;

    private Float ulna;
    private Float ulnaEsquerdo;
    private String ulnaMedia;
    private String ulnaMedidas;

    private Float tibia;
    private Float tibiaEsquerdo;
    private String tibiaMedia;
    private String tibiaMedidas;

    private Float cerebelo;
    private Float fibula;
    private Float radio;
    private Float fibulaEsquerdo;
    private Float radioEsquerdo;

    private Float calculadosIc;
    private Float calculadosCa;
    private Float calculadosCc;
    private Float calculadosCf;
    private Float calculadosPfp;
    private Float calculadosCfEsquerda;
    private Float calculadosPfpEsquerda;
    private Float calculadosEstatura;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_orgaos_internos_id", referencedColumnName = "codigo")
    private TextoSugestivo orgaosInternos;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_informacoes_feto_id", referencedColumnName = "codigo")
    private InformacoesFeto informacoesFeto;

    @Enumerated(EnumType.STRING)
    private EnumCrescimento crescimentoFetal;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_cranio_fetal_id", referencedColumnName = "codigo")
    private TextoSugestivo cranioFetal;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_face_fetal_id", referencedColumnName = "codigo")
    private TextoSugestivo faceFetal;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_pescoco_fetal_id", referencedColumnName = "codigo")
    private TextoSugestivo pescocoFetal;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_coluna_fetal_id", referencedColumnName = "codigo")
    private TextoSugestivo colunaFetal;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_torax_id", referencedColumnName = "codigo")
    private TextoSugestivo torax;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_coracao_id", referencedColumnName = "codigo")
    private TextoSugestivo coracao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_abdome_fetal_id", referencedColumnName = "codigo")
    private TextoSugestivo abdomeFetal;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_vias_urinarias_id", referencedColumnName = "codigo")
    private TextoSugestivo viasUrinarias;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_membros_fetais_id", referencedColumnName = "codigo")
    private TextoSugestivo membrosFetais;
}
