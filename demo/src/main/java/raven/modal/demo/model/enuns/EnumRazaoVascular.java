package raven.modal.demo.model.enuns;

public enum EnumRazaoVascular {
    naoImprime("naoImprime"), normal("normal"),
    hiperVascularUm("hiperVascularUm"), hiperVascularDois("hiperVascularDois"),
    hiperVascularDescrito("hiperVascularDescrito");

    private String valor;

    EnumRazaoVascular(String valor) {
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
