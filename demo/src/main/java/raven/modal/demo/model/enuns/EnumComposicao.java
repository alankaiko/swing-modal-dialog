package raven.modal.demo.model.enuns;

public enum EnumComposicao {
    cistica("cistica"), quaseCistica("quaseCistica"),
    espongiforme("espongiforme"), mistoCistica("mistoCistica"),
    quaseSolida("quaseSolida"), solida("solida"),
    naoDeterminada("naoDeterminada");

    private String valor;

    EnumComposicao(String valor) {
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
