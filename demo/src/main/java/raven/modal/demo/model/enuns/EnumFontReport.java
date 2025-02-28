package raven.modal.demo.model.enuns;

public enum EnumFontReport {
    padrao("FreeUniversal"), times("TimesNewRoman");

    private String valor;

    EnumFontReport(String valor) {
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
