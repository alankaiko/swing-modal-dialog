package raven.modal.demo.model.laudos.topicos;

import raven.modal.demo.core.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "historicolaudo")
public class HistoricoLaudo extends AbstractEntity {
    @OneToMany(cascade = CascadeType.ALL)
    private List<HistoricoLaudoAnotacao> historicoLaudoAnotacoes;
}
