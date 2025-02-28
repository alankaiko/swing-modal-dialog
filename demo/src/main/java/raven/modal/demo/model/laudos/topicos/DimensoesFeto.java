package raven.modal.demo.model.laudos.topicos;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "dimensoesfeto")
public class DimensoesFeto extends AbstractEntity {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_arteria_umbilical_id", referencedColumnName = "codigo")
    private ArteriaMedidas arteriaUmbilical;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_arteria_cerebral_id", referencedColumnName = "codigo")
    private ArteriaMedidas arteriaCerebral;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_arteria_uterina_direita_id", referencedColumnName = "codigo")
    private ArteriaMedidas arteriaUterinaDireita;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_arteria_uterina_equerda_id", referencedColumnName = "codigo")
    private ArteriaMedidas arteriaUterinaEquerda;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_ducto_id", referencedColumnName = "codigo")
    private Ducto ducto;

    private Double relacaoSdDividido;
    private Double relacaoIrDividido;
    private Double relacaoIpDividido;
}
