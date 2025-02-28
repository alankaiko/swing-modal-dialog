package raven.modal.demo.model.enuns;

public enum EnumPencencias {
	SEMPENDENCIA("SEMPENDENCIA"), PENDENCIA("PENDENCIA"), BLOQUEADO("BLOQUEADO");
			  
	private String valor;

	private EnumPencencias(String valor) {
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