package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "databloqueioagenda")
public class DataBloqueioAgenda extends AbstractEntity {
    private LocalDate data;

    @OneToMany(cascade = CascadeType.ALL)
    private List<HorarioBloqueadoAgenda> horariosBloqueados;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_id", referencedColumnName = "codigo")
    private Usuario usuarioAlteracao;

    private LocalDate dataAlteracao;
}
