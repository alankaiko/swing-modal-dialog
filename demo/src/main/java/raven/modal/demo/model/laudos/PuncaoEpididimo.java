package raven.modal.demo.model.laudos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.ProcedimentoAtendimento;
import raven.modal.demo.model.laudos.topicos.TextoSugestivo;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "puncaoepididimo")
public class PuncaoEpididimo extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "tbl_procedimento_atendimento_id", referencedColumnName = "codigo")
    private ProcedimentoAtendimento procedimentoAtendimento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_puncao_epididimo_id", referencedColumnName = "codigo")
    private TextoSugestivo puncaoEpididimo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_puncao_finalidade_id", referencedColumnName = "codigo")
    private TextoSugestivo puncaoFinalidade;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_puncao_conclusao_id", referencedColumnName = "codigo")
    private TextoSugestivo puncaoConclusao;

}