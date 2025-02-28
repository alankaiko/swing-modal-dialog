package raven.modal.demo.model.enuns;

public enum EnumFormaNoduloTireoide {
    larguraMaior("larguraMaior"), alturaMaior("alturaMaior");

    private String valor;

    EnumFormaNoduloTireoide(String valor) {
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
