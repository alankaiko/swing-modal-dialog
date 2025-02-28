package raven.modal.demo.model.enuns;

public enum EnumSacoGestacional {
	um("1"), dois("2"), tres("3"), quatro("4"), cinco("5"), cincomaior("> 5");
	
	private String valor;

	private EnumSacoGestacional(String valor) {
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