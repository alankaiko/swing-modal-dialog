package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "calculovolume")
public class CalculoVolume extends AbstractEntity {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_texto_sugestivo_id", referencedColumnName = "codigo")
    private TextoSugestivo textoSugestivo;
    private Double diamLongitudinal;
    private Double diamAntPost;
    private Double diamDiamTransversal;
    private Double volume;
    private Double volumeTotal;

    @Enumerated(EnumType.STRING)
    private EnumSimNao cisto;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cisto> cistos;
}
