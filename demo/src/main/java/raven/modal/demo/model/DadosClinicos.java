package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class DadosClinicos extends AbstractEntity {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_paciente_dados_clinico_id", referencedColumnName = "codigo")
    private PacienteDadosClinico pacienteDadosClinico;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_conjugue_dados_clinico_id", referencedColumnName = "codigo")
    private ConjugueDadosClinico conjugueDadosClinico;
}
