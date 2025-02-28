package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "checkdataatendimento")
public class CheckDataAtendimento extends AbstractEntity {

    private LocalDate dataAtendimento;

    @Column(length = 800)
    private String observacao;

    private String responsavel;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_id", referencedColumnName = "codigo")
    private Usuario usuario;
}
