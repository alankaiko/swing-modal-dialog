package raven.modal.demo.model.enuns;

public enum EnumHGG {
	naorealizado("Não Realizado"), chorimiomom("Choriomom 5000"), chorimiomom10("Choriomom 10.000"), ovidel("Ovidel"), lupron("Lupron 40mg"),
	gonapeptil("Gonapeptil"), lupronhcg("Lupron 40mg+1500 HCG"), fecha("Fecha");
	
	private String valor;

	private EnumHGG(String valor) {
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