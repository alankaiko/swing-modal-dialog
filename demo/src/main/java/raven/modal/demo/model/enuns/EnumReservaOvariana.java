package raven.modal.demo.model.enuns;

public enum EnumReservaOvariana {
	naoimprime("Não imprime"), normal("Normal"), diminuida("Diminuida"), muitodiminuida("Muito Diminuida"),
	aumentada("Aumentada"), aumentadapadrao("Aumentada Padrao SOP");
	
	private String valor;

	private EnumReservaOvariana(String valor) {
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