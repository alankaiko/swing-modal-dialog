package raven.modal.demo.model.laudos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.model.ProcedimentoAtendimento;
import raven.modal.demo.model.laudos.topicos.LaudoPadrao;
import raven.modal.demo.model.laudos.topicos.TextoSugestivo;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "colposcopia")
public class Colposcopia extends LaudoPadrao {

    @ManyToOne
    @JoinColumn(name = "tbl_procedimento_atendimento_id", referencedColumnName = "codigo")
    private ProcedimentoAtendimento procedimentoAtendimento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_texto_equipamento_id", referencedColumnName = "codigo")
    private TextoSugestivo textoEquipamento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_vulvoscopia_id", referencedColumnName = "codigo")
    private TextoSugestivo vulvoscopia;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_vaginoscopia_id", referencedColumnName = "codigo")
    private TextoSugestivo vaginoscopia;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_cervicoscopia_id", referencedColumnName = "codigo")
    private TextoSugestivo cervicoscopia;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_colposcopia_alargada_id", referencedColumnName = "codigo")
    private TextoSugestivo colposcopiaAlargada;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_biopsia_id", referencedColumnName = "codigo")
    private TextoSugestivo biopsia;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_impressao_diagnostica_id", referencedColumnName = "codigo")
    private TextoSugestivo impressaoDiagnostica;
}
