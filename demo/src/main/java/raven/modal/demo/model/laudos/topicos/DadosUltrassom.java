package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumCiclo;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "dadosultrassom")
public class DadosUltrassom extends AbstractEntity {
    private Double peso;
    private Double altura;
    private String imc;

    @Enumerated(EnumType.STRING)
    private EnumSimNao fumante;

    private String status;
    private String classificacao;

    private String fsh;
    private String amh;
    private String estradiol;

    private LocalDate dum1;

    private LocalDate dum2;

    @Enumerated(EnumType.STRING)
    private EnumCiclo ciclo;

    private LocalDate primeirodiainducao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OvarioFoliculos> ovariofoliculos;

    private String avaliacaoreserva;
    private String previsaofoliculos;

    @Column(length = 2000)
    private String achadosecograficosanormais;

    @Column(length = 850)
    private String texto;
}
