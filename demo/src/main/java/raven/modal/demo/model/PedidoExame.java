package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pedidoexame")
public class PedidoExame extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    private Paciente paciente;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pedidoexame_exames", joinColumns = @JoinColumn(name = "codigo_pedidoexame"),
            inverseJoinColumns = @JoinColumn(name = "codigo_exame"))
    private List<Exame> listaexames;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_id", referencedColumnName = "codigo")
    private Usuario usuario;

    @Column(length = 10000)
    private String textopedido;

    private String indicacao;
    private boolean somenteobservacao;
    private String observacao;
    private String outrosexames;

    @OneToOne
    @JoinColumn(name = "tbl_medico_id", referencedColumnName = "codigo")
    private Profissional medico;

    private Integer quantidade;
}
