package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumLabelCores;
import raven.modal.demo.model.enuns.EnumTipoDadosEquipamento;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "procedimentomedico")
public class ProcedimentoMedico extends AbstractEntity {
    private Integer codigoprocedimento;
    private String titulo;
    private String nomeoriginal1;
    private String nomeoriginal2;
    private String titulocomplemento;

    @ManyToOne
    @JoinColumn(name = "grupo_codigo", referencedColumnName = "codigo")
    private GrupoProcedimento grupo;
    private EnumTipoDadosEquipamento tipoequipamento;
    private float frequencia;

    @Enumerated(EnumType.STRING)
    private EnumLabelCores cor;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TabelaPreco> tabelaPrecos;
}
