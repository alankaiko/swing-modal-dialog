package raven.modal.demo.model.enuns;

public enum EnumIntercorrencias {
	nenhum("Nenhum"), malformacao("Malformação fetal"), amnirorrexe("Amnirorrexe"), rciu("RCIU"), 
	polidramnio("Polidramnio"), oligamnio("Oligoamnio"), tpp("TPP"), cerclagem("Cerclagem");

	private String valor;

	EnumIntercorrencias(String valor) {
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
