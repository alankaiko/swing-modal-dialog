package raven.modal.demo.model.enuns;

public enum EnumLaudoPosicaoOvario {
	NaoImprimir("NaoImprimir"), ParaUterino("ParaUterino"), Posterior("Posterior"), Superior("Superior"),
	Anterior("Anterior"), Pelvico("Pelvico"), NaoVisualizado("NaoVisualizado"), Descrito("Descrito");
	
	private String valor;

	private EnumLaudoPosicaoOvario(String valor) {
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
