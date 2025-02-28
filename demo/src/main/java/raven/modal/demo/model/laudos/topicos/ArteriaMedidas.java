package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumDuctoVenoso;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "arteriamedidas")
public class ArteriaMedidas extends AbstractEntity {
    private double relacaosd;
    private double relacaoac;
    private double ir;
    private double ip;

    @Enumerated(EnumType.STRING)
    private EnumSimNao incisura;

    @Enumerated(EnumType.STRING)
    private EnumDuctoVenoso diastole;

    private double picoSistolico;
}
