package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "medicacaoutilizada")
public class MedicacaoUtilizada extends AbstractEntity {
    @Column(length = 2000)
    private String esquemamedicamentos;

    @Enumerated(EnumType.STRING)
    private EnumAnalogo analogo;

    @Enumerated(EnumType.STRING)
    private EnumEsquema esquema;
    private String primeiradose;
    private String antanistas;
    private String descricaoadicional;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MedicacaoEsquemaDetalhado> esquemadetalhados;

    @Enumerated(EnumType.STRING)
    private EnumInducaoOvulacao inducaoovulacao;

    private String diasinducao;
    private String unidadefshr;
    private String unidadehmg;
    private String unidadelhr;

    @Enumerated(EnumType.STRING)
    private EnumSimNao cc;

    @Enumerated(EnumType.STRING)
    private EnumSimNao inibidoraromatase;

    @Enumerated(EnumType.STRING)
    private EnumHGG hgg;
    private String hcgtexto;


    private LocalDate datahgg;
    private String dchgg;
    private String dihgg;
    private String hora;
    private String faselutea;
    private String lutea2;

    @Column(length = 850)
    private String texto;
}
