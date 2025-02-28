package raven.modal.demo.model.enuns;

public enum EnumTipoParto {
    cesaria("cesaria"), normal("normal");

    private String valor;

    EnumTipoParto(String valor) {
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