package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table
@Entity
public class Imagem extends AbstractEntity {
    private String caminho;
    private String nomeimagem;
    private String extensao;

    private boolean dicom;
    private String codigouid;

}
