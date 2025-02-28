package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.laudos.topicos.CausaInfertilidadeAnamnese;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Anamnese extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_gravidez_anamnese_id", referencedColumnName = "codigo")
    private GravidezAnamnese gravidezAnamnese;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_causa_infertilidade_anamnese_id", referencedColumnName = "codigo")
    private CausaInfertilidadeAnamnese causaInfertilidade;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_tratamento_gravidez_id", referencedColumnName = "codigo")
    private TratamentoGravidez tratamentoGravidez;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_tratamento_previo_gravidez_id", referencedColumnName = "codigo")
    private TratamentoGravidez tratamentoPrevioGravidez;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_antecedente_anamnese_id", referencedColumnName = "codigo")
    private AntecedenteAnamnese antecedenteAnamnese;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_antecedente_cirurgico_id", referencedColumnName = "codigo")
    private AntecedenteCirurgico antecedenteCirurgico;
}






































