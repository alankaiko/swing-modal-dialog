package raven.modal.demo.model.enuns;

public enum EnumAcompanhante {
	pai("Pai"), mae("Mãe"), conjugue("Cônjugue"), outros("Outros");
	
	private String valor;
	
	private EnumAcompanhante(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}
