package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "termofichadoador")
public class TermoFichaDoador extends AbstractEntity {

    private LocalDateTime dataHora;

    private String versaoTermo;

    private boolean aceito;

    private String ipUsuario;

    private String dispositivo;

    private String navegador;

    private String hashTermo;
}






































