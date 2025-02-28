package raven.modal.demo.model.enuns;

public enum EnumDia {
	um("1° dia"), dois("2° dia"), tres("3° dia"), quatro("4° dia"), cinco("5° dia"), 
	seis("6° dia"), sete("7° dia"), oito("8° dia"), nove("9° dia");
	
	private String valor;
	
	private EnumDia(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}
