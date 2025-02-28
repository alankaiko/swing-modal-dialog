package raven.modal.demo.model.enuns;

public enum EnumPosicao {
    centrado("centrado"), direita("direita"), esquerda("esquerda");

    private String valor;

    EnumPosicao(String valor) {
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
