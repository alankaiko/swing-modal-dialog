package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;
import raven.modal.demo.model.enuns.EnumStatusAgendamento;
import raven.modal.demo.model.enuns.EnumTipoAtendimento;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class AtendimentoDTO extends AbstractDTO {
    private String nomePaciente;

    private String nomeConvenio;

    private String nomeMedico;

    private LocalDate dataatendimento;

    private String nomeUnidade;

    private String nomeDepartamento;

    private String nomeProcedimento;

    private Date dataInicialRangeInicio;

    private Date dataInicialRangeFim;

    @Enumerated(EnumType.STRING)
    private EnumStatusAgendamento statusAgendamento;

    @Enumerated(EnumType.STRING)
    private EnumTipoAtendimento tipoAtendimento;

    private Long codigoUnidade;

    private Long codigoDepartamento;

    private Long codigoProfissional;

    private Long codigoRegistro;

    private Boolean telaAtendimento;
}
