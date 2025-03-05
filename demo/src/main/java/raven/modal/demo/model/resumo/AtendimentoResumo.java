package raven.modal.demo.model.resumo;


import lombok.Getter;
import lombok.Setter;
import raven.modal.demo.model.enuns.EnumStatusAgendamento;
import raven.modal.demo.model.enuns.EnumTipoAtendimento;

import java.time.LocalDate;

@Getter
@Setter
public class AtendimentoResumo {
    private Long codigo;

    private String nomePaciente;

    private LocalDate dataatendimento;

    private String tipo;

    private String status;

    private String nomeMedico;

    private String unidade;

    public AtendimentoResumo(long codigo, LocalDate dataAtendimento, EnumTipoAtendimento tipoAtendimento,
                             EnumStatusAgendamento statusAgendamento, String nomePaciente,
                             String nomeProfissional, String nomeUnidade) {
        this.codigo = codigo;
        this.dataatendimento = dataAtendimento;
        this.tipo = this.montarTipoAtendimento(tipoAtendimento);
        this.status = this.montarStatus(statusAgendamento);
        this.nomePaciente = nomePaciente;
        this.nomeMedico = nomeProfissional;
        this.unidade = nomeUnidade;
    }

    private String montarTipoAtendimento(EnumTipoAtendimento valor) {
        if (valor == null)
            return "";

        switch (valor) {
            case CONSULTA:
                return "Consulta";
            case MONITORIZACAO:
                return "Monitorização";
            case ROTINAGINECOLOGICA:
                return "Rotina Ginecológica";
            case ROTINARETORNO:
                return "Rotina Retorno";
            case TTO:
                return "TTo";
            case TTO1VEZ:
                return "TTo 1° vez";
            case TTORETORNO:
                return "TTo Retorno";
            case PRENATALCOMUN:
                return "Pré-natal";
            case PRENATAL:
                return "Pré-natal 1° vez";
            case PRENATALRETORNO:
                return "Pré-natal Retorno";
            case ROTINAPOSPARTO:
                return "Rotina pós parto";
            case EXAME:
                return "Exame";
            case COLETA:
                return "Coleta";
            case TRANSFERENCIA:
                return "Transferência";
            case PARTICULAR:
                return "Particular";
            case ROTINA:
                return "Rotina";
            case TELECONSULTA:
                return "Teleconsulta";
            default:
                return "";
        }
    }

    private String montarStatus(EnumStatusAgendamento status) {
        if (status == null)
            return "";

        switch (status) {
            case PARTICULAR:
                return "Particular";
            case AGENDADO:
                return "Agendado";
            case AGUARDANDO:
                return "Aguardando";
            case CHAMADO:
                return "Chamado";
            case REAGENDAR:
                return "Reagendar";
            case ATENDIDO:
                return "Atendido";
            case CANCELADOPELOPACIENTE:
                return "Cancelado pelo paciente";
            case VEIOEDESISTIU:
                return "Veio e desistiu";
            case CANCELADOPELACLINICA:
                return "Cancelado pela clínica";
            case TRANSFERIDO:
                return "Transferido";
            case ENCAIXE:
                return "Encaixe";
            case CANCELADOPELOCONSULTORIO:
                return "Cancelado pelo consultório";
            default:
                return "";
        }
    }

}
