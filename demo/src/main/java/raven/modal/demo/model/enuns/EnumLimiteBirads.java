package raven.modal.demo.model.enuns;

public enum EnumLimiteBirads {
    abuptro("abuptro"), ecogenico("ecogenico");

    private String valor;

    EnumLimiteBirads(String valor) {
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
