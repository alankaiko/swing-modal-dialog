package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "dadosgravidez")
public class DadosGravidez extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumSacoGestacional sacogestacional;

    @Enumerated(EnumType.STRING)
    private EnumEvolucaoGravidez evolucaogravidez;

    private LocalDate datapartoaborto;

    @Enumerated(EnumType.STRING)
    private EnumIdadeParto idadeparto;

    @Enumerated(EnumType.STRING)
    private EnumTipoGravidez tipogravidez;

    private String ig;
    private String peso;
    private EnumSexo sexo;

    @Enumerated(EnumType.STRING)
    private EnumIntercorrencias intercorencias;

    @Column(length = 2000)
    private String observacao;

    @Column(length = 2000)
    private String observacao2;

    private String impressasinistro;

    @Enumerated(EnumType.STRING)
    private EnumReservaOvariana reservaovariana;
}
