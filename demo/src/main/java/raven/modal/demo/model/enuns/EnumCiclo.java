package raven.modal.demo.model.enuns;

public enum EnumCiclo {
	cicloinduzido("Ciclo Induzido"), cicloespontaneo("Ciclo Espontâneo"), preparoendometrial("Preparo Endometrial");
	
	private String valor;
	
	private EnumCiclo(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}

