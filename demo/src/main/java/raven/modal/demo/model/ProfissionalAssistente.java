package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "profissionalassistente")
public class ProfissionalAssistente extends AbstractEntity {
    @Column(nullable = false)
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_conselho_id", referencedColumnName = "codigo")
    private TISSConselho conselho;

    @OneToOne
    @JoinColumn(name = "tbl_especialidade_id", referencedColumnName = "codigo")
    private EspecialidadeDoProfissional especialidade;

    private String observacao;

    private String cpf;
}
