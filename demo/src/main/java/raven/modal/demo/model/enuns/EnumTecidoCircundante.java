package raven.modal.demo.model.enuns;

public enum EnumTecidoCircundante {
    naoImprime("naoImprime"), ductos("ductos"),
    cooper("cooper"), edema("edema"),
    arquitetural("arquitetural"), cutaneo("cutaneo"),
    pele("pele");

    private String valor;

    EnumTecidoCircundante(String valor) {
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
