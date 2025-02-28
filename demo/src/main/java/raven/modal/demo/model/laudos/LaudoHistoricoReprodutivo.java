package raven.modal.demo.model.laudos;


import raven.modal.demo.model.Paciente;
import raven.modal.demo.model.laudos.topicos.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "historicoreprodutivo")
public class LaudoHistoricoReprodutivo extends Laudo {
    private Long codigo;
    private Paciente paciente;
    private LocalDate dataexame;
    private TempoInfertilidade tempoinfertilidade;
    private CausaInfertilidade causainfertilidade;
    private DadosUltrassom dadosultrassom;
    private MedicacaoUtilizada medicacaoutilizada;
    private ICSIEjaculado icsiejaculado;
    private DadosLaboratoriais dadoslaboratoriais;
    private DadosGravidez dadosgravidez;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    @OneToOne
    @JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo")
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getDataexame() {
        return dataexame;
    }

    public void setDataexame(LocalDate dataexame) {
        this.dataexame = dataexame;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_tempoinfertilidader_id", referencedColumnName = "codigo")
    public TempoInfertilidade getTempoinfertilidade() {
        return tempoinfertilidade;
    }

    public void setTempoinfertilidade(TempoInfertilidade tempoinfertilidade) {
        this.tempoinfertilidade = tempoinfertilidade;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_causainfertilidade_id", referencedColumnName = "codigo")
    public CausaInfertilidade getCausainfertilidade() {
        return causainfertilidade;
    }

    public void setCausainfertilidade(CausaInfertilidade causainfertilidade) {
        this.causainfertilidade = causainfertilidade;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_dadosultrassom_id", referencedColumnName = "codigo")
    public DadosUltrassom getDadosultrassom() {
        return dadosultrassom;
    }

    public void setDadosultrassom(DadosUltrassom dadosultrassom) {
        this.dadosultrassom = dadosultrassom;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_medicacaoutilizada_id", referencedColumnName = "codigo")
    public MedicacaoUtilizada getMedicacaoutilizada() {
        return medicacaoutilizada;
    }

    public void setMedicacaoutilizada(MedicacaoUtilizada medicacaoutilizada) {
        this.medicacaoutilizada = medicacaoutilizada;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_icsiejaculado_id", referencedColumnName = "codigo")
    public ICSIEjaculado getIcsiejaculado() {
        return icsiejaculado;
    }

    public void setIcsiejaculado(ICSIEjaculado icsiejaculado) {
        this.icsiejaculado = icsiejaculado;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_dadoslaboratoriais_id", referencedColumnName = "codigo")
    public DadosLaboratoriais getDadoslaboratoriais() {
        return dadoslaboratoriais;
    }

    public void setDadoslaboratoriais(DadosLaboratoriais dadoslaboratoriais) {
        this.dadoslaboratoriais = dadoslaboratoriais;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_dadosgravidez_id", referencedColumnName = "codigo")
    public DadosGravidez getDadosgravidez() {
        return dadosgravidez;
    }

    public void setDadosgravidez(DadosGravidez dadosgravidez) {
        this.dadosgravidez = dadosgravidez;
    }

}
