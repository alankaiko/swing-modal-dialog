package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Table
@Entity
public class Configuracao extends AbstractEntity {
    private String titulo;

    @OneToOne
    @JoinColumn(name = "tbl_confg_atestado_id", referencedColumnName = "codigo")
    private ConfiguracaoLaudo configuracaoAtestado;

    @OneToOne
    @JoinColumn(name = "tbl_configuracao_pedido_exame_id", referencedColumnName = "codigo")
    private ConfiguracaoLaudo configuracaoPedidoExame;

    @OneToOne
    @JoinColumn(name = "tbl_laudo_id", referencedColumnName = "codigo")
    private ConfiguracaoLaudo configuracaoLaudo;

    @OneToOne
    @JoinColumn(name = "tbl_configuracao_receita_id", referencedColumnName = "codigo")
    private ConfiguracaoLaudo configuracaoReceita;

    @OneToOne
    @JoinColumn(name = "tbl_impressao_paciente_id", referencedColumnName = "codigo")
    private ConfiguracaoLaudo configuracaoImpressaoPaciente;

    @OneToOne
    @JoinColumn(name = "tbl_configuracao_impressao_lembrete_id", referencedColumnName = "codigo")
    private ConfiguracaoLaudo configuracaoImpressaoLembretes;

    @OneToOne
    @JoinColumn(name = "tbl_configuracao_impressao_nota_paciente_id", referencedColumnName = "codigo")
    private ConfiguracaoLaudo configuracaoNotaPaciente;

    @OneToOne
    @JoinColumn(name = "tbl_configuracao_impressao_declaracao_id", referencedColumnName = "codigo")
    private ConfiguracaoLaudo configuracaoDeclaracao;

    @OneToOne
    @JoinColumn(name = "tbl_configuracao_impressao_encaminhar_paciente_id", referencedColumnName = "codigo")
    private ConfiguracaoLaudo configuracaoEncaminharPaciente;

    @OneToOne
    @JoinColumn(name = "tbl_configuracao_impressao_anamnese_id", referencedColumnName = "codigo")
    private ConfiguracaoLaudo configuracaoAnamnese;

    @OneToOne
    @JoinColumn(name = "tbl_configuracao_recibo_paciente_id", referencedColumnName = "codigo")
    private ConfiguracaoLaudo configuracaoReciboPaciente;

    @OneToOne
    @JoinColumn(name = "tbl_configuracao_laudo_reproducao_id", referencedColumnName = "codigo")
    private ConfiguracaoLaudo configuracaoLaudoReproducao;

    @OneToOne
    @JoinColumn(name = "tbl_configuracao_dados_clinicos_id", referencedColumnName = "codigo")
    private ConfiguracaoLaudo configuracaoDadosClinicos;

    @OneToOne
    @JoinColumn(name = "tbl_impressao_ficha_doador_id", referencedColumnName = "codigo")
    private ConfiguracaoLaudo configuracaoFichaDoador;

    @OneToOne
    @JoinColumn(name = "tbl_configuracao_agenda_id", referencedColumnName = "codigo")
    private ConfiguracaoLaudo configuracaoAgenda;

    private Double calculovolumebase;
    private Double calculopesoprostata;
}
