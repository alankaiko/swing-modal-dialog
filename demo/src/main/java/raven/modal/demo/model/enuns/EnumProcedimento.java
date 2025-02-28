package raven.modal.demo.model.enuns;

public enum EnumProcedimento {
    investigacao("investigacao"), coitoProgramado("coitoProgramado"),
    inseminacaoHomologa("inseminacaoHomologa"), inseminacaoHeterologa("inseminacaoHeterologa"),
    icsiEjaculadoOvuloProprio("icsiEjaculadoOvuloProprio"), icsiPuncao("icsiPuncao"),
    doadoraOvulo("doadoraOvulo"), criotransferenciaOvuloProprio("criotransferenciaOvuloProprio"),
    uteroSubstituicao("uteroSubstituicao"), icsiOvuloDoado("icsiOvuloDoado"),
    congelamentoOvulo("congelamentoOvulo"), icsiSemeCongelado("icsiSemeCongelado"),
    cicloEspontaneo("cicloEspontaneo"), posTratamentoPrevio("posTratamentoPrevio"),
    doacao("doacao"), crioTotalEmbriao("crioTotalEmbriao"),
    criotranferenciaDoacaoOvulo("criotranferenciaDoacaoOvulo"), icsiCompartilhamento("icsiCompartilhamento"),
    icsiPuncaoCompartilhamento("icsiPuncaoCompartilhamento"), receptoraEmbrioes("receptoraEmbrioes"),
    era("era"), duostin("duostin"), nenhuma("nenhuma");

    private String valor;

    EnumProcedimento(String valor) {
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
