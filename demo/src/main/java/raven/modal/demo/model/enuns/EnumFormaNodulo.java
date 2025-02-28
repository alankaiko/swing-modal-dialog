package raven.modal.demo.model.enuns;

public enum EnumFormaNodulo {
    ovoide("ovoide"), redonda("redonda"), irregular("irregular");

    private String valor;

    EnumFormaNodulo(String valor) {
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
