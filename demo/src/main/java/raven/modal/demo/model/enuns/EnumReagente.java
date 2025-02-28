package raven.modal.demo.model.enuns;

public enum EnumReagente {
    Indeterminado("Indeterminado"), NaoReagente("NaoReagente"),
    Reagente("Reagente"), Ignorado("Ignorado");

    private String valor;

    EnumReagente(String valor) {
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
