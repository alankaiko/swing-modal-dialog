package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "topicochecadomarcado")
public class TopicoChecadoMarcado extends AbstractEntity {
    @Column(length = 500)
    private String descricao;

    private Boolean checado;

    private Integer posicaoTopico;

    private Date dataHoraRegistrada;

    private Boolean marcado;

    private Boolean bloqueioEdicao;
}
