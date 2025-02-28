package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumDadosContratado;
import raven.modal.demo.model.enuns.EnumEstado;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "dadossolicitante")
public class DadosSolicitante extends AbstractEntity {
    private String sigla;

    private String numeroConselho;

    @Enumerated(EnumType.STRING)
    private EnumEstado uf;

    private String nomeSolicitante;

    private String cpf;

    private String cbos;

    private boolean editaInformacoes;

    @Enumerated(EnumType.STRING)
    private EnumDadosContratado enumDadosContratado;

    private String nomeContratado;

    private String cnes;
}
