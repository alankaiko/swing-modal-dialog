package raven.modal.demo.model.enuns;

public enum EnumInsercaoPlacenta2 {
    anterior("anterior"), posterior("posterior"), fundica("fundica"),
    fundicaPosterior("fundicaPosterior"), fundicaAnterior("fundicaAnterior"),
    anterLateralDireita("anterLateralDireita"), anterLateralEsquerda("anterLateralEsquerda"),
    postLateralDireita("postLateralDireita"), postLateralEsquerda("postLateralEsquerda"),
    lateralDireita("lateralDireita"), lateralEsquerda("lateralEsquerda");

    private String valor;

    EnumInsercaoPlacenta2(String valor) {
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
