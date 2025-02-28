package raven.modal.demo.model.enuns;

public enum EnumEmbrioesTransferidos {
	um("1"), dois("2"), tres("3"), quatromaior(">= 4");
	
	private String valor;

	private EnumEmbrioesTransferidos(String valor) {
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