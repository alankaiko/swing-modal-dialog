package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.Usuario;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "historicolaudoanotacao")
public class HistoricoLaudoAnotacao extends AbstractEntity {
    private Date dataAnotacao;

    @Column(length = 1500)
    private String descricao;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_id", referencedColumnName = "codigo")
    private Usuario usuario;
}
