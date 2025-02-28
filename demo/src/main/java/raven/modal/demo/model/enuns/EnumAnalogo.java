package raven.modal.demo.model.enuns;

public enum EnumAnalogo {
	analogonaousado("Análogo Não Usado"), agonista("Agonista"), antagonista("Antagonista"), progesterona("Progesterona");
	
	private String valor;
	
	private EnumAnalogo(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}

