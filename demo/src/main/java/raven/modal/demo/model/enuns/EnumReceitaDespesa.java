package raven.modal.demo.model.enuns;

public enum EnumReceitaDespesa {
    RECEITA("RECEITA"), DESPESA("DESPESA");

    private String valor;

    EnumReceitaDespesa(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
