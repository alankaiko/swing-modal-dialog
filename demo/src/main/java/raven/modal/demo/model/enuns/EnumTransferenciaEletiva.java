package raven.modal.demo.model.enuns;

public enum EnumTransferenciaEletiva {
	nao("Não"), embriao1("1 Embrião"), embriao2("2 Embriões"), abaixo("Abaixo");
	
	private String valor;

	EnumTransferenciaEletiva(String valor) {
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
