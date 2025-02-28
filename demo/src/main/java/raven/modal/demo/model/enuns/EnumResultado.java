package raven.modal.demo.model.enuns;

public enum EnumResultado {
	negativo("Negativo"), positivo("Positivo"), naorealizado("Não Realizado");
	  
	private String valor;

	private EnumResultado(String valor) {
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
