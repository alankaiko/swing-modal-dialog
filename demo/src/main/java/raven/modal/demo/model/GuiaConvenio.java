package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "guiaconvenio")
public class GuiaConvenio extends AbstractEntity {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_identificacao_guia_id", referencedColumnName = "codigo")
    private IdentificacaoGuia identificacaoGuia;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_dados_solicitante_id", referencedColumnName = "codigo")
    private DadosSolicitante dadosSolicitante;

    @OneToOne
    @JoinColumn(name = "tbl_profissional_executante_id", referencedColumnName = "codigo")
    private Profissional profissionalExecutante;

    private String indicacaoClinica;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_dados_atendimento_saida_id", referencedColumnName = "codigo")
    private DadosAtendimentoSaida dadosAtendimentoSaida;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_diagnostico_guia_id", referencedColumnName = "codigo")
    private DiagnosticoGuia diagnosticoGuia;
}
