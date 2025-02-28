package raven.modal.demo.model.enuns;

public enum EnumTipoGravidez {
    unico("Único"), gemelar("Gemelar"), trigemelar("Trigemelar"),
    quadrigemelar("Quadrigemelar"), quintuplos("Quintúplos"),
    maiorouigual6("Maior ou igual a 6"), gravidezbioquimica("Gravidez Bioquímica"),
    gravidezectopica("Gravidez Ectópica"), bioquimicainterditada("Bioquímica Interditada"),
    dicorionica("dicorionica"), monocorionica("monocorionica");

    private String valor;

    EnumTipoGravidez(String valor) {
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
