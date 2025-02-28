package raven.modal.demo.model.dto;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractDTO;
import raven.modal.demo.model.Permissao;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UsuarioDTO extends AbstractDTO {
    private Long codigo;
    private String nome;
    private String sobrenome;
    private String login;
    private LocalDate datacadastro;
    private Long idunidadeempresa;
    private Long idcompania;
    private List<Permissao> permissoes;
    private boolean ativo;

    public UsuarioDTO(Long codigo, String nome, String login, LocalDate datacadastro, Long idunidadeempresa, Long idcompania) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.login = login;
        this.datacadastro = datacadastro;
        this.idunidadeempresa = idunidadeempresa;
        this.idcompania = idcompania;
    }
}
