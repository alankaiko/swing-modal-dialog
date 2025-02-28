package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumGrupoSanguineo;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pacientedadosclinico")
public class PacienteDadosClinico extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;

    private Double peso;
    private Double altura;
    private Double imc;

    @Enumerated(EnumType.STRING)
    private EnumGrupoSanguineo gruposanguineo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_historico_pessoal_dados_clinicos_id", referencedColumnName = "codigo")
    private HistoricoPessoalDadosClinicos historicoPessoalDadosClinicos;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_historico_familiar_dados_clinicos_id", referencedColumnName = "codigo")
    private HistoricoFamiliarDadosClinicos historicoFamiliarDadosClinicos;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TriagemSorologicaDadosClinicos> triagemSorologicaDadosClinicosList;
}
