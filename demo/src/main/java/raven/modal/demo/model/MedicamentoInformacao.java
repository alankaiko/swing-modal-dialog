package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class MedicamentoInformacao {
    @Column(length = 1200)
    private String apresentacao;

    @Column(length = 1200)
    private String substanciasativas;

    @Column(length = 1200)
    private String indicacao;

    @Column(length = 1200)
    private String contraindicacao;

    @Column(length = 1200)
    private String efeitocolateral;
}
