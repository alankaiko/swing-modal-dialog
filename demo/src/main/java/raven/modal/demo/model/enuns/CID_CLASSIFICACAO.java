package raven.modal.demo.model.enuns;

public enum CID_CLASSIFICACAO {
    EM_BRANCO(""),
    POSITIVO("+"),
    ASTERISCO("*");

    private final String classificacao;

    CID_CLASSIFICACAO(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getClassificacao() {
        return classificacao;
    }

}
