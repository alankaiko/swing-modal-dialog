package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "examearmazenamento")
public class ExameArmazenamento extends AbstractEntity {
    @OneToMany(cascade = CascadeType.ALL)
    private List<DadosArmazenamento> dadosArmazenamentos;

    private String botijao;
    private String caneca;

    @Column(length = 1000)
    private String observacao;
}
