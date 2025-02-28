package raven.modal.demo.model.enuns;

public enum EnumDirecao {
	Esquerda("Esquerda"), Direita("Direita"), Cima("Cima"), Abaixo("Abaixo");

	private String valor;

	private EnumDirecao(String valor) {
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
