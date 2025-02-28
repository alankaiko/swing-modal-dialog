package raven.modal.demo.model.laudos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.model.ProcedimentoAtendimento;
import raven.modal.demo.model.enuns.EnumOtoacustica;
import raven.modal.demo.model.enuns.EnumSimNao;
import raven.modal.demo.model.enuns.EnumTriagemConclusao;
import raven.modal.demo.model.laudos.topicos.LaudoPadrao;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "triagemauditiva")
public class TriagemAuditiva extends LaudoPadrao {

    @ManyToOne
    @JoinColumn(name = "tbl_procedimento_atendimento_id", referencedColumnName = "codigo")
    private ProcedimentoAtendimento procedimentoAtendimento;

    @Column(length = 500)
    private String historico;

    @Enumerated(EnumType.STRING)
    private EnumSimNao simNao;

    @Column(length = 500)
    private String simNaoDescricao;

    private String equipamentoUtilizado;

    private String outrosEquipamento;

    @Enumerated(EnumType.STRING)
    private EnumOtoacustica otoacusticaEsquerda;

    @Enumerated(EnumType.STRING)
    private EnumOtoacustica otoacusticaDireita;

    @Enumerated(EnumType.STRING)
    private EnumTriagemConclusao triagemConclusao;

    @Column(length = 1000)
    private String passou;

    @Column(length = 1000)
    private String falhou;

    @Column(length = 1000)
    private String observacoes;

    @Column(length = 1000)
    private String conduta;

    private Date dataConsulta;
}
