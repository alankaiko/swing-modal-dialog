package raven.modal.demo.model;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumSenhaPainel;
import raven.modal.demo.model.enuns.EnumTipoSenhaAtendimento;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@Entity
@Table(name = "senhaatendimento")
public class SenhaAtendimento extends AbstractEntity {
    private Integer senha;

    private String senhaApresentacao;

    @Enumerated(EnumType.STRING)
    private EnumTipoSenhaAtendimento tipoSenha;

    private LocalDate dataRegistroSenha;

    private LocalTime horaRegistro;

    @Enumerated(EnumType.STRING)
    private EnumSenhaPainel senhaPainel;

    private Integer posicao;

    private Integer versao;

    @ManyToOne
    @JoinColumn(name = "tbl_tipo_senha_atendimento_id", referencedColumnName = "codigo")
    private TipoSenhaAtendimento tipoSenhaAtendimento;

    private String tituloEmpresa;

    private String endereco;
}






































