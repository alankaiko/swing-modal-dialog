package raven.modal.demo.model.enuns;

public enum EnumLaudoPadraoIdadeGestacao {
	PadraoClassico("PadraoClassico"), Definido("Definido");
	
	private String valor;

	private EnumLaudoPadraoIdadeGestacao(String valor) {
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
