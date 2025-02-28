package raven.modal.demo.model.enuns;

public enum EnumTerco {
    naoImprime("naoImprime"), superior("superior"),
    inferior("inferior"), medio("medio");

    private String valor;

    EnumTerco(String valor) {
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
