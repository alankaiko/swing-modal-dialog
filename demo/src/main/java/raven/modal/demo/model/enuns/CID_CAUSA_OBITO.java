package raven.modal.demo.model.enuns;

public enum CID_CAUSA_OBITO {
    EM_BRANCO("NÃO HÁ RESTRIÇÃO"),
    N("POUCA PROBABILIDADE");

    private final String causaObito;

    CID_CAUSA_OBITO(String causaObito) {
        this.causaObito = causaObito;
    }

    public String getCausaObito() {
        return causaObito;
    }

    @Override
    public String toString() {
        return causaObito;
    }

}
