package raven.modal.demo.model.enuns;

public enum EnumBeneficiario {
    proprio("proprio"), terceiro("terceiro");

    private String valor;

    EnumBeneficiario(String valor) {
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
