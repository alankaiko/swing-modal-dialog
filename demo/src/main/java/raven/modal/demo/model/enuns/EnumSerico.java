package raven.modal.demo.model.enuns;

public enum EnumSerico {
    analisador("analisador"), delfia("delfia"),
    kryptor("kryptor"), roche("roche");

    private String valor;

    EnumSerico(String valor) {
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
