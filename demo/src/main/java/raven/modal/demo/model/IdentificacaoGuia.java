package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSimNao;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "identificacaoguia")
public class IdentificacaoGuia extends AbstractEntity {
    private LocalDate dataEmissao;
    private String numeroGuiaPrestador;
    private String numeroGuiaOperadora;
    private String numeroGuiaPrincipal;
    private LocalDate dataAutorizacao;
    private String senhaAutorizacao;
    private LocalDate validadeSenha;
    private EnumSimNao simNao;
}
