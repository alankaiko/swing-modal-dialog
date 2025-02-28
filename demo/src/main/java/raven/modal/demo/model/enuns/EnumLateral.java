package raven.modal.demo.model.enuns;

public enum EnumLateral {
    naoImprimir("naoImprimir"), unilateral("unilateral"), bilateral("bilateral");

    private String valor;

    EnumLateral(String valor) {
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
