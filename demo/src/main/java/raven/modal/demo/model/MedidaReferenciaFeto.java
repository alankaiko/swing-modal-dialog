package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "medidareferenciafeto")
public class MedidaReferenciaFeto extends AbstractEntity {
    private Integer numeroSemana;
    private String diametroBiparietal;
    private String indiceCefalico;
    private String circunferenciaAbdomFetal;
    private String circunferenciaCranianaFetal;
    private String cranianaAbdominal;
    private String comprimentoFemur;
    private String hadLock;
    private String comprimentoUmero;
    private String comprimentoUlna;
    private String comprimentoTibia;
    private String pesoFetalProvavel;
    private String estaturaFetal;
    private String sexoFetalProvavel;
    private String gorduraPrePeritonial;
    private String estadiamentoIntestinal;
}
