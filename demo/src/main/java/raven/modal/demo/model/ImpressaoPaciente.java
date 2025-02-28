package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Table
@Entity(name = "impressaopaciente")
public class ImpressaoPaciente extends AbstractEntity {
    private boolean imprimeregistrovisitas;
    private boolean separagrupos;
    private int espacamento;

    private boolean nome;
    private boolean cpf;
    private boolean rg;
    private boolean idade;
    private boolean nomepai;
    private boolean nomemae;
    private boolean profissao;
    private boolean dataalteracao;
    private boolean datanascimento;
    private boolean logradouro;
    private boolean complemento;
    private boolean bairro;
    private boolean cidade;
    private boolean estado;
    private boolean cep;
    private boolean numero;
    private boolean telefone1;
    private boolean telefone2;
    private boolean celular;
    private boolean email;
    private boolean sexo;
    private boolean estadocivil;
    private boolean observacao;
    private boolean indicacao;
    private boolean nomeconjugue;
    private boolean datanascimentoconjugue;
    private boolean idadeconjugue;
    private boolean telefoneconjugue;
    private boolean celularconjugue;
    private boolean emailconjugue;
    private boolean profissaoconjugue;
    private boolean corpele;
    private boolean corcabelo;
    private boolean corolhos;
    private boolean datacadastrodados;
    private boolean distanciacidade;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_id", referencedColumnName = "codigo")
    private Usuario usuario;

    private boolean dataatendimento;
    private boolean tipoatendimento;

    private boolean datapacientehistorico;
}
