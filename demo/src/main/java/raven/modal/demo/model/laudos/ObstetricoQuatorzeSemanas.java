package raven.modal.demo.model.laudos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.model.ProcedimentoAtendimento;
import raven.modal.demo.model.enuns.EnumFormulaPesoFetal;
import raven.modal.demo.model.laudos.topicos.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "obstetricoquatorzesemanas")
public class ObstetricoQuatorzeSemanas extends LaudoPadrao {

    @ManyToOne
    @JoinColumn(name = "tbl_procedimento_atendimento_id", referencedColumnName = "codigo")
    private ProcedimentoAtendimento procedimentoAtendimento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_dados_equipamento_id", referencedColumnName = "codigo")
    private DadosEquipamento dadosEquipamento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_amenorreia_id", referencedColumnName = "codigo")
    private DadosAmenoExame amenorreia;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_ultimo_exame_id", referencedColumnName = "codigo")
    private DadosAmenoExame ultimoExame;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_idade_gestacional_id", referencedColumnName = "codigo")
    private IdadeGestacional idadeGestacional;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_numero_embrioes_id", referencedColumnName = "codigo")
    private NumeroEmbrioes numeroEmbrioes;

    @Column(length = 1500)
    private String observacoesGerais;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_impressao_diagnostica_id", referencedColumnName = "codigo")
    private TextoSugestivo impressaoDiagnostica;

    @Enumerated(EnumType.STRING)
    private EnumFormulaPesoFetal formulaPesoFetal;
}
