package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "procedimentofuncionariochecklist")
public class ProcedimentoFuncionarioCheckList extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "tbl_departamento_checado_id", referencedColumnName = "codigo")
    private DepartamentoChecado departamento;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ItemChecado> itensChecados;

    private LocalDate dataAlteracao;
}
