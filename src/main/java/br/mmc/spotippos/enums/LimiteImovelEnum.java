package br.mmc.spotippos.enums;

public enum LimiteImovelEnum {
	
	QUARTO 		(1, 5),
	BANHEIRO 	(1, 4),
	POSICAO_X	(0, 1400),
	POSICAO_Y	(0, 1000),
	METRO_QUADRADO (0, 1400000);
	
	private int min;
	private int max;
	

	private LimiteImovelEnum (int min, int max) {
		this.setMin(min);
		this.setMax(max);
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}

}
