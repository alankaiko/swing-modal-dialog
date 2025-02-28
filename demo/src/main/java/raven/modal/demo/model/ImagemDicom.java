package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ImagemDicom extends AbstractEntity {
    private Long codigo;
    private String nome;
    private Date data;
    private String descricao;
    private byte[] imagemJpeg;
    private byte[] arquivoDicom;
}
