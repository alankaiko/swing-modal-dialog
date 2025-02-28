package raven.modal.demo.model.enuns;

public enum EnumLabelCores {
	yellow("yellow"), turquoise("turquoise"), green("green"),
	lightblue("lightblue"), gray("gray"), orange("orange"), white("white"),
	blue("blue"), blueviolet("blueviolet"), brown("brown"), burlywood("burlywood"), cadetblue("cadetblue"), darkorange("darkorange"),
	chartreuse("chartreuse"), chocolate("chocolate"), coral("coral"), cornflowerblue("cornflowerblue"), crimson("crimson"),
	darkblue("darkblue"), darkcyan("darkcyan"), darkgoldenrod("darkgoldenrod"), darkmagenta("darkmagenta"), darkkhaki("darkkhaki");

	private String valor;
	
	EnumLabelCores(String valor) {
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
