package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumCaraterAtendimento;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "dadosatendimentosaida")
public class DadosAtendimentoSaida extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumCaraterAtendimento enumCaraterAtendimento;
    private Date dataAtendimento;
    private Integer tipoAtendimento;
    private Integer tipoSaida;

    private Date horaInicialProcedimento;

    private Date horaFinalProcedimento;
}
