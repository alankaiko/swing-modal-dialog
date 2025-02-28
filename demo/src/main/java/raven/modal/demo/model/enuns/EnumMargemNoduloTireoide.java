package raven.modal.demo.model.enuns;

public enum EnumMargemNoduloTireoide {
    lisa("lisa"), malDelimitada("malDelimitada"), lobulada("lobulada"),
    irregular("irregular"), sinaisInvasao("sinaisInvasao"),
    naoDeterminada("naoDeterminada");

    private String valor;

    EnumMargemNoduloTireoide(String valor) {
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
