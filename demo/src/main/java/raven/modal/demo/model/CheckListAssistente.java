package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "checklistassistente")
public class CheckListAssistente extends AbstractEntity {
    private EnumSimNao orientacaoExame;
    private EnumSimNao exameSolicitado;
    private EnumSimNao exameColetado;
    private EnumSimNao resultadoEntregue;

    @Column(length = 1800)
    private String listaExame;

    private LocalDate dataAtendimento;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CheckDataAtendimento> assistendeDataAtendimentos;

    private LocalDate dataConclusao;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_id", referencedColumnName = "codigo")
    private Usuario usuario;
}
