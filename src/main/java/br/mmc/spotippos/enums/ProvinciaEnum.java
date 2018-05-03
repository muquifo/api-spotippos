package br.mmc.spotippos.enums;

public enum ProvinciaEnum {
	
	GODE 	(1, "Gode",0,1000,600,500, 300000),
	RUJA 	(2, "Ruja",400, 1000, 1100, 500, 350000),
	JABY 	(3, "Jaby", 1100, 1000, 1400, 500, 150000),
	SCAVY	(4, "Scavy", 0, 500, 600, 0, 300000),
	GROOLA	(5, "Groola", 600, 500, 800, 0, 100000),
	NOVA	(6, "Nova", 800, 500, 1400, 0, 300000);
	
	private int id;
	private String descricao;
	private int ax;
	private int ay;
	private int bx;
	private int by;
	private int areaTotalm2;
	

	private ProvinciaEnum (int id, String descricao, int ax, int ay, int bx, int by, int areaTotalm2) {
		this.id = id;
		this.descricao = descricao;
		this.ax = ax;
		this.ay = ay;
		this.bx = bx;
		this.by = by;
		this.areaTotalm2 = areaTotalm2;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public int getAx() {
		return ax;
	}


	public void setAx(int ax) {
		this.ax = ax;
	}


	public int getAy() {
		return ay;
	}


	public void setAy(int ay) {
		this.ay = ay;
	}


	public int getBx() {
		return bx;
	}


	public void setBx(int bx) {
		this.bx = bx;
	}


	public int getBy() {
		return by;
	}


	public void setBy(int by) {
		this.by = by;
	}


	public int getAreaTotalm2() {
		return areaTotalm2;
	}


	public void setAreaTotalm2(int areaTotalm2) {
		this.areaTotalm2 = areaTotalm2;
	}
	
}
