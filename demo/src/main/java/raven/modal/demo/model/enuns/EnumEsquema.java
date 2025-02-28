package raven.modal.demo.model.enuns;

public enum EnumEsquema {
	cetrotide("Cetrotíde"), orgalutran("Orgalutran"), synarel("Synarel"), lupron("Lupron 10 Un"), 
	lectrum("Lectrun"), lorelin("Lorelin"), zoladex("Zoladex"), neodecapeptyl("Neo decapeptyl");
	
	private String valor;
	
	EnumEsquema(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}

