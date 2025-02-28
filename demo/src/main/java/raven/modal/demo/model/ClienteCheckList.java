package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "clientechecklist")
public class ClienteCheckList extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_check_list_assistente", referencedColumnName = "codigo")
    private CheckListAssistente checkListAssistente;

    private boolean checkListAssistenteConcluido;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_check_list_financeiro", referencedColumnName = "codigo")
    private CheckListFinanceiro checkListFinanceiro;

    private boolean checkListFinanceiroConcluido;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_check_list_biomedico", referencedColumnName = "codigo")
    private CheckListBiomedica checkListBiomedica;

    private boolean checkListBiomedicaConcluido;
}
