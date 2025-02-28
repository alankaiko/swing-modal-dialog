package raven.modal.demo.model.laudos.topicos;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "numerofetos")
public class NumeroFetos extends AbstractEntity {
    private int qtdFetos;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DimensoesFeto> dimensoesFetos;

    private double mediaRelacaoSd;
    private double mediaValoresIr;
    private double mediaValoresIp;
    private double mediaRelacoesAc;
    private String incisuraBilateral;
}
