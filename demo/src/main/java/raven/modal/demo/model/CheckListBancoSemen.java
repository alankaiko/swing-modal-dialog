package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "bancosemenchecklist")
public class CheckListBancoSemen extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;

    private Integer numeroFilhos;

    private String idadeFilhos;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_checkList_semen_financeiro", referencedColumnName = "codigo")
    private CheckListSemenFinanceiro checkListSemenFinanceiro;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_check_list_semen_triagem", referencedColumnName = "codigo")
    private CheckListSemenTriagem checkListSemenTriagem;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_check_list_semen_avaliacao", referencedColumnName = "codigo")
    private CheckListSemenAvaliacao checkListSemenAvaliacao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_check_list_semen_familia", referencedColumnName = "codigo")
    private CheckListSemenFamilia checkListSemenFamilia;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_banco_semen_embriao", referencedColumnName = "codigo")
    private CheckListSemenEmbriao bancoSemenEmbriao;
}
