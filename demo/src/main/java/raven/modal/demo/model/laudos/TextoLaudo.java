package raven.modal.demo.model.laudos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.ProcedimentoAtendimento;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "textolaudo")
public class TextoLaudo extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "tbl_procedimento_atendimento_id", referencedColumnName = "codigo")
    private ProcedimentoAtendimento procedimentoAtendimento;

    @Column(length = 50000)
    private String texto;
}
