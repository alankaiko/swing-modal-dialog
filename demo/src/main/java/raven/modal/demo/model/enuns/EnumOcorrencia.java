package raven.modal.demo.model.enuns;

public enum EnumOcorrencia {
	aspiracaoovulou("Aspiração - Ovulou Espontâneo (ñ expirou)"), aspiracaoausencia("Aspiração - Ausência de óvulos"),
	fertilizacaoausencia("Fertilização -Ausência de fertilização"), embriaoausencia("Embrião - Ausência de embriões"),
	transferenciacancelada("Transfêrencia - Transf. cancelada c/ embrião"), transferenciaembriao("Transfêrencia de embrião  c/sucesso"),
	investigacao("Investigação concluida"), cpconcluida("CP Concluida"), inseminacao("Inserminação Concluida"), 
	procedimentocancelado("Procedimento cancelado"), criototal("Crio total de óvulos"), 
	transferenciasubstituicao("Transfêrencia embrião p/ útero substituição"), criototalembrioes("Crio total de embriões"), 
	criotransferencia("Criotransfêrencia de Doacão de Óvulos"), doadoraovulos("Doadora de Óvulos");
	
	private String valor;

	EnumOcorrencia(String valor) {
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
