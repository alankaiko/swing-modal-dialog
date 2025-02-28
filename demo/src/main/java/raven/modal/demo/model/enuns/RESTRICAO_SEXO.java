package raven.modal.demo.model.enuns;

public enum RESTRICAO_SEXO {
    NENHUMA_RESTRICAO("NENHUMA RESTRICÃO"),
    APENAS_MASCULINO("APENAS MASCULINO"),
    APENAS_FEMININO("APENAS FEMININO");

    private final String descricao;

    RESTRICAO_SEXO(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

}
