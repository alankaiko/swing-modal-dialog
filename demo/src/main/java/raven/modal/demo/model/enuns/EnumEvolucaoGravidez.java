package raven.modal.demo.model.enuns;

public enum EnumEvolucaoGravidez {
    bioquimica("bioquimica"), gravidezClinica("gravidezClinica"), ectopica("ectopica"),
    inducaoAborto("inducaoAborto"), abortouMenos20semana("abortouMenos20semana"),
    nascidoMorto20semana("nascidoMorto20semana"), nascidoMorto28semana("nascidoMorto28semana"),
    nascidoVivo("nascidoVivo"), nascidoMorto("nascidoMorto"),
    morteNeonatal("morteNeonatal"), desconhecido("desconhecido");

    private String valor;

    EnumEvolucaoGravidez(String valor) {
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