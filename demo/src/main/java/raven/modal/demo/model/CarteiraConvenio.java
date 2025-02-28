package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "carteiraconvenio")
public class CarteiraConvenio extends AbstractEntity {
    private LocalDate datavalidade;
    private String numero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;
}
