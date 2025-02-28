package raven.modal.demo.model.enuns;

public enum EnumTransferencia {
	dia2("Dia 2"), dia3("Dia 3"), blastocisto("Blastocisto");

	private String valor;

	EnumTransferencia(String valor) {
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
