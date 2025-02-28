package raven.modal.demo.model.enuns;

public enum EnumLocalizacaoTireoide {
    loboDireito("loboDireito"), loboEsquerdo("loboEsquerdo"),
    istmo("istmo"), naoEspecificado("naoEspecificado");

    private String valor;

    EnumLocalizacaoTireoide(String valor) {
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
