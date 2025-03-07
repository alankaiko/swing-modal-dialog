package raven.modal.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Paciente extends AbstractEntity {
    private String nome;
    private String cpf;
    private String rg;
    private int idade;
    private Integer idadeMes;
    private String nomepai;
    private String nomemae;
    private String profissao;

    private LocalDate dataalteracao;

    private Long codigousuarioultimaalteracao;

    private LocalDate datanascimento;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;

    @Enumerated(EnumType.STRING)
    private EnumSexo sexo;

    @Enumerated(EnumType.STRING)
    private EnumEstadoCivil estadocivil;

    @Column(length = 3500)
    private String observacao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_imagem_id", referencedColumnName = "codigo")
    private Imagem imagem;

    private String indicacao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_conjugue_id", referencedColumnName = "codigo")
    private Conjugue conjugue;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_dadosadicionais_id", referencedColumnName = "codigo")
    private DadosAdicionaisPaciente dadosadicionais;

    @Enumerated(EnumType.STRING)
    private EnumCor corpele;

    @Enumerated(EnumType.STRING)
    private EnumCorCabelo corcabelo;

    @Enumerated(EnumType.STRING)
    private EnumCorOlhos corolhos;
    private boolean desativado;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_criado_id", referencedColumnName = "codigo")
    private Usuario criadopor;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_desativado_id", referencedColumnName = "codigo")
    private Usuario desativadopor;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente")
    private List<CarteiraConvenio> carteiras;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Estudo> estudos;

    private String pacienteid;
    private String tamanho;
    private String peso;
    private boolean dicom;

    private String uuid;

    private String distanciaCidade;
}
