package raven.modal.demo.model.enuns;

public enum EnumMedicamentoDiabete {
    apenasDieta("apenasDieta"), insulina("insulina"),
    insulinaMetmorfina("insulinaMetmorfina"), metmorfina("metmorfina");

    private String valor;

    EnumMedicamentoDiabete(String valor) {
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
