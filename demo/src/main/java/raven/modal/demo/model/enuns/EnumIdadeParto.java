package raven.modal.demo.model.enuns;

public enum EnumIdadeParto {
	semana20("20 a 27 semanas"), semana28("28 a 31 semanas"), semana32("32 a 36 semanas"),
	semana37("37 a 41 semanas"), semana42("> 42 semanas"), desconhecido("Desconhecido");
	
	private String valor;
	
	private EnumIdadeParto(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}
