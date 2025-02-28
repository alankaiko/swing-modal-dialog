package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSerico;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "medidasbiofisica")
public class MedidasBiofisica extends AbstractEntity {
    private float pressaoArterialMedia;
    private float sistolicoEsquerdo1;
    private float sistolicoDireito1;
    private float diastolicoEsquerdo1;
    private float diastolicoDireito1;

    private float sistolicoEsquerdo2;
    private float sistolicoDireito2;
    private float diastolicoEsquerdo2;
    private float diastolicoDireito2;

    private float arteriaUterinaMedia;
    private float uterinaEsquerda;
    private float uterinaDireita;

    private LocalDate dataMedicaoBiofisica;

    private int plgfSerico;
    private float plgfMamaeSerico;
    private float plgfDadosSerico;

    @Enumerated(EnumType.STRING)
    private EnumSerico enumPLGFSerico;

    private int pappSerico;
    private float pappMamaeSerico;
    private float pappDadosSerico;

    @Enumerated(EnumType.STRING)
    private EnumSerico enumPAPPSerico;

    private LocalDate dataMedicaoBioquimica;

}





















