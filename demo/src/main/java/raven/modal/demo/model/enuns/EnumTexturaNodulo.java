package raven.modal.demo.model.enuns;

public enum EnumTexturaNodulo {
    cistica("cistica"), solida("solida"), solidaCistica("solidaCistica");

    private String valor;

    EnumTexturaNodulo(String valor) {
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
