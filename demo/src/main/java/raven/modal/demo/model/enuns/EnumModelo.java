package raven.modal.demo.model.enuns;

public enum EnumModelo {
	padrao("padrao"), preconfigurado("preconfigurado");

	private String valor;

	EnumModelo(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}
