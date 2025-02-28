package raven.modal.demo.model.laudos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.ProcedimentoAtendimento;
import raven.modal.demo.model.enuns.EnumCorVolume;
import raven.modal.demo.model.enuns.EnumViscosidade;

import javax.persistence.*;

@Getter
@Setter
@Table
@Entity
public class Espermograma extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "tbl_procedimento_atendimento_id", referencedColumnName = "codigo")
    private ProcedimentoAtendimento procedimentoAtendimento;

    private Integer tempoAbstinencia;
    private String localColeta;
    private Double volume;

    @Enumerated(EnumType.STRING)
    private EnumCorVolume cor;

    @Enumerated(EnumType.STRING)
    private EnumViscosidade viscosidade;

    private Integer liquefacao;
    private Double ph;
    private Double concentracaoMl;
    private Double concentracaoVolume;
    private Integer moveisProgressivos;
    private Integer totalMoveis;
    private Integer rapidaLinear;
    private Integer movimentoLento;
    private Integer movimentoNaoProgressivo;
    private Integer imoveis;
    private Integer vitalidadeVivos;

    @Column(length = 1000)
    private String vitalidadeObservacao;

    private Integer vitalidadeMortos;
    private Double leucocitos;

    @Column(length = 1000)
    private String leucocitosObservacao;

    private Double kruger;
    private Integer sptzNormal;
    private Integer alteracaoCabeca;
    private Integer alteracaoIntermediaria;
    private Integer alteracaoCauda;
    private Integer alteracaoAmorfo;
    private Boolean leucocitosNenhumValor;
}
