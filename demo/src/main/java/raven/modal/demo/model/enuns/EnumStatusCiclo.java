package raven.modal.demo.model.enuns;

public enum EnumStatusCiclo {
	iniciado("1 Ciclo Iniciado"), cancelado("2 Ciclo Cancelado"), finalizado("3 Ciclo Finalizado"), proximo("4 Iniciar Próximo Ciclo");

	private String valor;

	EnumStatusCiclo(String valor) {
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
