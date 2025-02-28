package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "exameavaliacao")
public class ExameAvaliacao extends AbstractEntity {
    private Long codigo;
    private String totalfinal;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AmostraDia> amostrasdia;
}
