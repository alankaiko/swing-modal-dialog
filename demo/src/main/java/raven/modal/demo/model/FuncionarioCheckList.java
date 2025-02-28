package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "funcionariochecklist")
@Entity
public class FuncionarioCheckList extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "tbl_usuario_id", referencedColumnName = "codigo")
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_procedimento_funcionario_check_list_marcado_id", referencedColumnName = "codigo")
    private ProcedimentoFuncionarioCheckListMarcado procedimentoFuncionario;
}
