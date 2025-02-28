package raven.modal.demo.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private LocalDate datacadastro;

    @Column(name = "bloqueio_edicao")
    private Boolean bloqueioEdicao;

    @Column(name = "id_usuario_bloqueio")
    private Long idUsuarioBloqueio;

    @Column(name = "data_bloqueio")
    private LocalDate dataBloqueio;
}
