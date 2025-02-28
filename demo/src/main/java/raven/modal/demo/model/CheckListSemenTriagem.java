package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "checklistsementriagem")
public class CheckListSemenTriagem extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private EnumSimNao ligacaoVoz;

    private LocalDate ligacaoVozData;

    @Enumerated(EnumType.STRING)
    private EnumSimNao mensagemZap;

    private LocalDate mensagemZapData;

    @Column(length = 800)
    private String resposta;

    private LocalDate respostaData;

    @Enumerated(EnumType.STRING)
    private EnumSimNao ligacaoTelefone;

    private LocalDate ligacaoTelefoneData;

    @Enumerated(EnumType.STRING)
    private EnumSimNao semResposta;

    private LocalDate semRespostaData;
}
