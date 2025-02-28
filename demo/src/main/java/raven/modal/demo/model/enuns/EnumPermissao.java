package raven.modal.demo.model.enuns;

public enum EnumPermissao {
    ROLE_ZE("ROLE_ZE"), ROLE_PACIENTE("ROLE_PACIENTE"), ROLE_ADMINISTRADOR("ROLE_ADMINISTRADOR"),
    ROLE_MEDICO("ROLE_MEDICO"), ROLE_SECRETARIA("ROLE_SECRETARIA"),
    ROLE_TI("ROLE_TI"), ROLE_ATENDIMENTO("ROLE_ATENDIMENTO"),
    ROLE_FINANCEIRO("ROLE_FINANCEIRO"), ROLE_BIOMEDICO("ROLE_BIOMEDICO"),
    ROLE_TELEFONISTA("ROLE_TELEFONISTA"), ROLE_RECEPCIONISTA("ROLE_RECEPCIONISTA"),
    ROLE_AGENDA("ROLE_AGENDA"), ROLE_FINANCEIRO_ADM("ROLE_FINANCEIRO_ADM"),
    ROLE_PSICOLOGIA("ROLE_PSICOLOGIA"), ROLE_MATER_CLINICA("ROLE_MATER_CLINICA"),
    ROLE_LABORATORIO("ROLE_LABORATORIO"), ROLE_CENTRO_CIRURGICO("ROLE_CENTRO_CIRURGICO"),
    ROLE_FARMACIA("ROLE_FARMACIA"), ROLE_ENFERMEIRA("ROLE_ENFERMEIRA"), ROLE_MEMED("ROLE_MEMED");

    private String valor;

    EnumPermissao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}
