package raven.modal.demo.model.laudos.topicos;

import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.core.model.AbstractEntity;
import raven.modal.demo.model.enuns.EnumEmbrioesTransferidos;
import raven.modal.demo.model.enuns.EnumTransferencia;
import raven.modal.demo.model.enuns.EnumTransferenciaEletiva;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "dadoslaboratoriais")
public class DadosLaboratoriais extends AbstractEntity {
    private String laboratorio;
    private boolean assistedhatching;
    private boolean pgd;
    private boolean asptacaofragmentos;
    private boolean icsi;

    @Enumerated(EnumType.STRING)
    private EnumTransferencia transferencia;

    @Enumerated(EnumType.STRING)
    private EnumTransferenciaEletiva transferenciaeletiva;

    @Enumerated(EnumType.STRING)
    private EnumEmbrioesTransferidos embrioestransferidos;
}
