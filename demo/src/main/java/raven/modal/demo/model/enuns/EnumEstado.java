package raven.modal.demo.model.enuns;

public enum EnumEstado {
    GO("GO"), AC("AC"), AL("AL"), AP("AP"), AM("AM"),
    BA("BA"), CE("CE"), DF("DF"), ES("ES"), MA("MA"),
    MT("MT"), MS("MS"), MG("MG"), PA("PA"), PB("PB"),
    PR("PR"), PE("PE"), PI("PI"), RJ("RJ"), RN("RN"),
    RS("RS"), RO("RO"), RR("RR"), SC("SC"), SP("SP"),
    SE("SE"), TO("TO");

    private String valor;

    EnumEstado(String valor) {
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
