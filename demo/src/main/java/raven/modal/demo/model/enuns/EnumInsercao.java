package raven.modal.demo.model.enuns;

public enum EnumInsercao {
    naoImprime("naoImprime"), normoInserido("normoInserido"), insercaoBaixa("insercaoBaixa"),
    ectopico("ectopico");

    private String valor;

    EnumInsercao(String valor) {
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
