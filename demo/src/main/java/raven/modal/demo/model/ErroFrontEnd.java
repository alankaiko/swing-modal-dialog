package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "errofrontend")
public class ErroFrontEnd extends AbstractEntity {
    @Column(length = 100)
    private String description;

    @Column(length = 10000)
    private String message;

    @Column(length = 10000)
    private String stack;

    @Column(length = 30)
    private String ip;

    private Integer usuarioCodigo;

    @Column(length = 50)
    private String usuarioLogin;

    @Column(length = 100)
    private String usuarioNome;

    @Column(length = 100)
    private String rotaPagina;

    @Enumerated(EnumType.STRING)
    private EnumSimNao corrigido;

    private LocalDate dataCorrecao;

}
