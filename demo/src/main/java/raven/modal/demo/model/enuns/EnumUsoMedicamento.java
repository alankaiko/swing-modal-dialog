package raven.modal.demo.model.enuns;

public enum EnumUsoMedicamento {
    interno("interno"), externo("externo"), topico("topico"), retal("retal"), oral("oral"), ocular("ocular"), parental("parental"),
    sublingual("sublingual"), vaginal("vaginal"), nasal("nasal"), subcutaneo("subcutaneo"),
    subcutaneoprofundo("subcutaneoprofundo"), intradermico("intradermico"), intramuscular("intramuscular"),
    intravenoso("intravenoso"), lentedecontato("lentedecontato"), internalizado("internalizado"),
    externalizado("externalizado"), inalatorio("inalatorio");

    private String valor;

    EnumUsoMedicamento(String valor) {
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
