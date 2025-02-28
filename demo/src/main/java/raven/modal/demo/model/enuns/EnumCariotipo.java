package raven.modal.demo.model.enuns;

public enum EnumCariotipo {
	xx("xx"), xy("xy");

	private String valor;

	EnumCariotipo(String valor) {
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
