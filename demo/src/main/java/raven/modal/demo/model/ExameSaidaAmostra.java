package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumResultado;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "examesaidaamostra")
public class ExameSaidaAmostra extends AbstractEntity {
    private LocalDate datasaida;
    private String amostraenviadaclinica;
    private String telefoneclinica;
    private String cidadeclinica;
    private String estadoclinica;
    private String nomepaciente;
    private String nomeconjugue;

    @Embedded
    private Contato contato;

    @Embedded
    private Endereco endereco;
    private LocalDate dataenvio;
    private String nomebiomedica;
    private String qtdpaletas;
    private String registroamostraenviada;
    private String qtdpaletasrestantes;
    private String emailclinica;

    @Column(length = 4000)
    private String observacao;
    private EnumResultado resultadobeta;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_resultado_final_id", referencedColumnName = "codigo")
    private ResultadoFinalProcedimento resultadofinal;
}
