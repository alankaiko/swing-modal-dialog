package raven.modal.demo.model.enuns;

public enum EnumStatusMedico {
	ATIVO("ATIVO"), DESATIVADO("DESATIVADO"), APENASSOLICITANTE("APENASSOLICITANTE");
	
	private String valor;

	EnumStatusMedico(String valor) {
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
