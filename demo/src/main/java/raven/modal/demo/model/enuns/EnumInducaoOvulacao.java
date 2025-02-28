package raven.modal.demo.model.enuns;

public enum EnumInducaoOvulacao {
	cnrhfsh("GnRh(agonista)+r-FSH"), gnrhhmg("GnRh(agonista)+HMG"), gnrhhmgfsh("GnRh(agonista)+HMG+r-FSH"), 
	gnrhhmgufsh("GnRh(agonista)+HMG+u-FSH"), gnrhrfsh("GnRh(antagonista)+r-FSH"), gnrhhmganta("GnRh(antagonista)+HMG"), 
	gnrhhmgrfsh("GnRh(antagonista)+HMG+r-FSH"), rlhrfsh("r-LH+r-FSH"), clomifebe("Clomifebe+HMG"), 
	ciclonatural("Ciclo Natural"), outros("Outros");

	
	private String valor;
	
	private EnumInducaoOvulacao(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}

