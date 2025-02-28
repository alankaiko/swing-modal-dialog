package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumUnidadeMedicamento;
import raven.modal.demo.model.enuns.EnumUsoMedicamento;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Table
@Entity
public class Medicamento extends AbstractEntity {
    private String nome;
    private String textocomercial1;
    private String textocomercial2;
    private String textocomercial3;
    private Integer codigoImportacao;

    @ManyToOne
    @JoinColumn(name = "tbl_tipoparamedicamento_id", referencedColumnName = "codigo")
    private TipoParaMedicamento tipo;

    private String info;

    @Column(length = 2500)
    private String textoreceita;

    @Enumerated(EnumType.STRING)
    private EnumUsoMedicamento uso;

    @Enumerated(EnumType.STRING)
    private EnumUnidadeMedicamento unidade;

    private String outros;
    private boolean especial;

    @Embedded
    private MedicamentoInformacao informacao;

    private BigDecimal valorNota;
    private BigDecimal valorFinal;

    private String idMemed;
    private String posologia;
    private Integer quantidadeMemed;
}
