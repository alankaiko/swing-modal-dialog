package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Contato {
    private String telefone1;
    private String telefone2;
    private String celular;
    private String email;
}
