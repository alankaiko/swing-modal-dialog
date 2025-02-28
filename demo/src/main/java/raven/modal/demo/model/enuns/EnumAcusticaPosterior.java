package raven.modal.demo.model.enuns;

public enum EnumAcusticaPosterior {
    naoImprime("naoImprime"), nenhuma("nenhuma"),
    realce("realce"), sombra("sombra"),
    combinado("combinado");

    private String valor;

    EnumAcusticaPosterior(String valor) {
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
