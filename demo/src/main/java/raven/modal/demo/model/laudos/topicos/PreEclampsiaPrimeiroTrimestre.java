package raven.modal.demo.model.laudos.topicos;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "preeclampsiaprimeirotrimestre")
public class PreEclampsiaPrimeiroTrimestre extends AbstractEntity {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_caracteristicas_feto_id", referencedColumnName = "codigo")
    private CaracteristicasFeto caracteristicasFeto;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_caracteristicas_materna_id", referencedColumnName = "codigo")
    private CaracteristicasMaterna caracteristicasMaterna;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_medidas_biofisica_id", referencedColumnName = "codigo")
    private MedidasBiofisica medidasBiofisica;
}

















