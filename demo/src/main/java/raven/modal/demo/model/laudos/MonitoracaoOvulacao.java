package raven.modal.demo.model.laudos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.model.ProcedimentoAtendimento;
import raven.modal.demo.model.laudos.topicos.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "monitoracaoovulacao")
public class MonitoracaoOvulacao extends LaudoPadrao {

    @ManyToOne
    @JoinColumn(name = "tbl_procedimento_atendimento_id", referencedColumnName = "codigo")
    private ProcedimentoAtendimento procedimentoAtendimento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_tempo_infertilidade_id", referencedColumnName = "codigo")
    private TempoInfertilidade tempoInfertilidade;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_dados_ultrassom_id", referencedColumnName = "codigo")
    private DadosUltrassom dadosUltrassom;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_medicacao_utilizada_id", referencedColumnName = "codigo")
    private MedicacaoUtilizada medicacaoUtilizada;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_icsi_ejaculado_id", referencedColumnName = "codigo")
    private ICSIEjaculado icsiEjaculado;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_dados_laboratoriais_id", referencedColumnName = "codigo")
    private DadosLaboratoriais dadosLaboratoriais;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_dados_gravidez_id", referencedColumnName = "codigo")
    private DadosGravidez dadosGravidez;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_impressao_diagnostica_id", referencedColumnName = "codigo")
    private TextoSugestivo impressaoDiagnostica;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_historico_laudo_id", referencedColumnName = "codigo")
    private HistoricoLaudo historicoLaudo;
}
