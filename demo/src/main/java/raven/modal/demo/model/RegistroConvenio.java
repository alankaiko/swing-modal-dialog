package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "registroconvenio")
public class RegistroConvenio extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "tbl_convenio_id", referencedColumnName = "codigo")
    private Convenio convenio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;
    private String plano;
    private String numerocarteira;
}
