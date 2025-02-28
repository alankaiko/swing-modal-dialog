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
@Table(name = "checklistbiomedica")
public class CheckListBiomedica extends AbstractEntity {
    private EnumSimNao orientacaoExame;
    private EnumSimNao exameSolicitado;
    private EnumSimNao exameCorreto;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CheckDataAtendimento> biomedicaDataAtendimentos;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_id", referencedColumnName = "codigo")
    private Usuario usuario;
}
