package raven.modal.demo.model.enuns;

public enum EnumOrientacao {
    paralela("paralela"), naoParalela("naoParalela");

    private String valor;

    EnumOrientacao(String valor) {
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
