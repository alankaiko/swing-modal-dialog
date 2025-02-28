package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class Lembrete extends AbstractEntity {
    private LocalDate dataaviso;

    private LocalDate dataregistro;

    @OneToOne
    @JoinColumn(name = "tbl_visita_id", referencedColumnName = "codigo")
    private Visita visita;

    @Column(length = 4000)
    private String observacao;
    private boolean confirmarcontato;

    private LocalDate dataconfirmacaocontato;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_id", referencedColumnName = "codigo")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "tbl_unidade_id", referencedColumnName = "codigo")
    private UnidadeComp unidade;
    private boolean desativado;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_desativado_id", referencedColumnName = "codigo")
    private Usuario desativadopor;
}

