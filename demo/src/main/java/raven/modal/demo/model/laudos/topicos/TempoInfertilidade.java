package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.ProfissionalAssistente;
import raven.modal.demo.model.enuns.EnumProcedimento;
import raven.modal.demo.model.enuns.EnumStatusCiclo;
import raven.modal.demo.model.enuns.EnumTentativa;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tempoinfertilidade")
public class TempoInfertilidade extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumProcedimento procedimentoprevisto;

    @Enumerated(EnumType.STRING)
    private EnumProcedimento procedimentorealizado;

    @Enumerated(EnumType.STRING)
    private EnumTentativa tentativa;

    @Enumerated(EnumType.STRING)
    private EnumStatusCiclo status;

    private String tempodificuldade;
    private String indicacao;
    private String motivo;

    @OneToOne
    @JoinColumn(name = "tbl_medico_assistente_id", referencedColumnName = "codigo")
    private ProfissionalAssistente medicoassistente;

    @Column(length = 850)
    private String texto;
}
