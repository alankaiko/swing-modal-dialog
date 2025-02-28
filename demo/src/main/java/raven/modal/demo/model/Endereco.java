package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.model.enuns.EnumEstado;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Embeddable
public class Endereco {
    private String logradouro;
    private String complemento;
    private String bairro;

    private String cidade;

    @Enumerated(EnumType.STRING)
    private EnumEstado estado;
    private String cep;
    private String numero;
}
