package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "procedimentofuncionariochecklistmarcado")
public class ProcedimentoFuncionarioCheckListMarcado extends AbstractEntity {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_departamento_checado_id", referencedColumnName = "codigo")
    private DepartamentoChecadoMarcado departamento;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemChecadoMarcado> itensChecados;
}
