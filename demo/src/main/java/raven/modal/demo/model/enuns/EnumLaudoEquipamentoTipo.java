package raven.modal.demo.model.enuns;

public enum EnumLaudoEquipamentoTipo {
	NaoImprimir("NaoImprimir"), Linear("Linear"), Setorial("Setorial"),
	LinearSetorial("LinearSetorial"), Vaginal("Vaginal"), Convexo("Convexo");
	
	private String valor;

	private EnumLaudoEquipamentoTipo(String valor) {
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
