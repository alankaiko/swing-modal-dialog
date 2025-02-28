package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.StatusLaudo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "procedimentoatendimento")
public class ProcedimentoAtendimento extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "tbl_executante_id", referencedColumnName = "codigo")
    private Profissional executante;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "tbl_procedimentomedico_id", referencedColumnName = "codigo")
    private ProcedimentoMedico procedimentomedico;

    private LocalDate preventregalaudo;
    private LocalDate dataexecucao;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "tbl_laudo_id", referencedColumnName = "codigo")
//    private Laudo laudo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Imagem> imagens;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PaginaDeImagens> paginaimagenslaudo;

    @Transient
    private Atendimento atendimento;

    private BigDecimal valorNaTabela;

    private BigDecimal valorlivre;

    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    private StatusLaudo statusLaudo;
}
