package raven.modal.demo.model.enuns;

public enum EnumCategoriaBosniak {
    naoimprime("naoimprime"), categoria1("categoria1"), categoria2("categoria2"), categoria3("categoria3"),
    categoria4("categoria4"), categoria2f("categoria2f");

    private String valor;

    EnumCategoriaBosniak(String valor) {
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
