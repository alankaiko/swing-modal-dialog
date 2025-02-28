package raven.modal.demo.model.enuns;

public enum EnumLocalizacao {
    superiorExterno("superiorExterno"), superiorInterno("superiorInterno"),
    inferiorExterno("inferiorExterno"), inferiorInterno("inferiorInterno"),
    superiorLateral("superiorLateral"), inferiorLateral("inferiorLateral"),
    superiorMedial("superiorMedial"), inferiorMedial("inferiorMedial"),
    quadranteLateral("quadranteLateral"), quadranteSuperior("quadranteSuperior"),
    quadranteMedial("quadranteMedial"), quadranteInferior("quadranteInferior"),
    retroareolar("retroareolar"), prolongamento("prolongamento");

    private String valor;

    EnumLocalizacao(String valor) {
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
