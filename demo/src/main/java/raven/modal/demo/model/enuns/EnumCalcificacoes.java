package raven.modal.demo.model.enuns;

public enum EnumCalcificacoes {
    naoImprime("naoImprime"), macroCalcificacoes("macroCalcificacoes"),
    foraNodulo("foraNodulo"), nodulo("nodulo");

    private String valor;

    EnumCalcificacoes(String valor) {
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
