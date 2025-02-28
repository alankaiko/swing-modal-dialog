package raven.modal.demo.model.enuns;

public enum EnumLaudoReferencia {
	Sim("Sim"), Nao("Nao");
	
	private String valor;

	private EnumLaudoReferencia(String valor) {
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
