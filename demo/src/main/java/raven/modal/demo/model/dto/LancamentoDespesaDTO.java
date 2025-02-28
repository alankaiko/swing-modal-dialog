package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;

import java.time.LocalDate;

@Getter
@Setter
public class LancamentoDespesaDTO extends AbstractDTO {
    private String nomecaixa;
    private String nomemedico;

    private LocalDate dataLancamentoInicial;

    private LocalDate dataLancamentoFinal;
}
