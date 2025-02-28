package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "lembreteagenda")
public class LembreteAgenda extends AbstractEntity {
    private LocalDate dataAviso;

    @OneToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;

    private LocalDate dataConfirmacaoContato;

    private Boolean contatoEfetuado;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_registro_id", referencedColumnName = "codigo")
    private Usuario usuarioRegistro;

    private Long registroNaAgenda;
}

