package raven.modal.demo.model.enuns;

public enum EnumMargemNodulo {
    circunscrita("circunscrita"), indistinta("indistinta"), angular("angular"),
    microlobulada("microlobulada"), espiculada("espiculada");

    private String valor;

    EnumMargemNodulo(String valor) {
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
