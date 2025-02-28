package raven.modal.demo.model.laudos.topicos;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "medicacaoesquemadetalhado")
public class MedicacaoEsquemaDetalhado extends AbstractEntity {
    private Long codigo;
    private int diaCiclo;

    private LocalDate data;
    private String dose;
    private boolean estrogenio;
    private float estrogenioml;
    private boolean progesterona;
    private float progesteronaml;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_medicacaoutilizada_id", referencedColumnName = "codigo")
    private MedicacaoUtilizada medicacaoutilizada;

    private Boolean solicitarlh;
    private Double lhmuim;
}
