package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "checklistfinanceiro")
public class CheckListFinanceiro extends AbstractEntity {
    private EnumSimNao orientacaoExame;
    private EnumSimNao exameColetado;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CheckDataAtendimento> financeiroDataAtendimentos;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_id", referencedColumnName = "codigo")
    private Usuario usuario;
}
