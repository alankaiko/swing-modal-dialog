package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.Profissional;
import raven.modal.demo.model.enuns.EnumOcorrencia;
import raven.modal.demo.model.enuns.EnumResultado;
import raven.modal.demo.model.enuns.EnumSimNao;
import raven.modal.demo.model.enuns.EnumTipoGravidez;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "icsiejaculado")
public class ICSIEjaculado extends AbstractEntity {
    private LocalDate dataprocedimento;

    @Enumerated(EnumType.STRING)
    private EnumOcorrencia ocorrencia;

    @OneToOne
    @JoinColumn(name = "tbl_profissional_id", referencedColumnName = "codigo")
    private Profissional profissional;

    private String horapreparo;
    private String horaprocedimento;
    private String bhcg;

    @Enumerated(EnumType.STRING)
    private EnumResultado resultado;
    private String valor;

    @Enumerated(EnumType.STRING)
    private EnumTipoGravidez tipogravidez;

    @Enumerated(EnumType.STRING)
    private EnumSimNao crio;

    private String criotexto;
    private String observacao;
    private String resultadoultrassom;
    private LocalDate datahcg;

    private EnumSimNao sheo;
    private EnumSimNao hospitalizacao;
    private EnumSimNao parencentese;
    private int quantidadeParecentese;

    private LocalDate dataProvavelParto;
}
