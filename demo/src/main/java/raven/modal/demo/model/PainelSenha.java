package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "painelsenhas")
public class PainelSenha extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "tbl_guiche_id", referencedColumnName = "codigo")
    private Guiche guiche;

    @OneToOne
    @JoinColumn(name = "tbl_senha_atendimento_id", referencedColumnName = "codigo")
    private SenhaAtendimento senhaAtendimento;

    private LocalTime horaChamado;

    private Boolean chamado;
}






































