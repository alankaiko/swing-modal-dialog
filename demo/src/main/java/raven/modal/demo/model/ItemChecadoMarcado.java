package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "itemchecadomarcado")
public class ItemChecadoMarcado extends AbstractEntity {
    private String titulo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TopicoChecadoMarcado> topicoChecados;

    private Integer posicaoItem;

    private Date dataHoraRegistrada;

    private Boolean marcado;

    private Boolean bloqueioEdicao;
}
