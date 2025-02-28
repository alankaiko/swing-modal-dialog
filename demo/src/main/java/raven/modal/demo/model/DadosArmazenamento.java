package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table
public class DadosArmazenamento extends AbstractEntity {
    private String amostra;
    private String armazenamento;
    private String raqui;
}
