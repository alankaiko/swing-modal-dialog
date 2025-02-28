package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "horariobloqueadoagenda")
public class HorarioBloqueadoAgenda extends AbstractEntity {
    private Date hora;
    private Boolean selecionado;
}
