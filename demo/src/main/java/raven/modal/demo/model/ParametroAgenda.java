package raven.modal.demo.model;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "parametroagenda")
public class ParametroAgenda extends AbstractEntity {
    private String titulo;

    private LocalTime horainicio;

    private LocalTime horafim;

    private int intervalo;

    @OneToOne
    @JoinColumn(name = "tbl_medico_id", referencedColumnName = "codigo")
    private Profissional medico;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DataBloqueioAgenda> dataBloqueada;

    @OneToOne
    @JoinColumn(name = "tbl_usuario_id", referencedColumnName = "codigo")
    private Usuario usuarioAlteracao;

    private LocalDate dataAlteracao;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "parametro_agenda_unidades", joinColumns = @JoinColumn(name = "codigo_parametro_agenda"),
            inverseJoinColumns = @JoinColumn(name = "codigo_unidade"))
    private Set<UnidadeComp> unidades;
}
