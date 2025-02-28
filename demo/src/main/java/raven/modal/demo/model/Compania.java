package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class Compania extends AbstractEntity {
    private String razaosocial;

    private String fantasia;

    private LocalDate dataalteracao;

    private Long codigousuarioultimaalteracao;
}
