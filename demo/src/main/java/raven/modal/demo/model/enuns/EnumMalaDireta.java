package raven.modal.demo.model.enuns;

public enum EnumMalaDireta {
	ENVIARWHATSAPP("ENVIARWHATSAPP"), ENVIAREMAIL("ENVIAREMAIL"), ENVIARTELEFONE("ENVIARTELEFONE"), NAOENVIAR("NAOENVIAR");
	
	private String valor;

	private EnumMalaDireta(String valor) {
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