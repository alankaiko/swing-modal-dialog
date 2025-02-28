package raven.modal.demo.model.enuns;

public enum EnumJustificado {
	start("start"), center("center"), end("end");

	private String valor;

	EnumJustificado(String valor) {
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
