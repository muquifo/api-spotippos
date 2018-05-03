package br.mmc.spotippos.response;

import java.util.List;

import br.mmc.spotippos.model.Imovel;

public class ImovelProvinciaResponse {
	
	
	private static final long serialVersionUID = 1L;
	
	
	private int totalImoveis;
	
	private List<Imovel> listaImoveis;

	
	
	public int getTotalImoveis() {
		return totalImoveis;
	}

	public void setTotalImoveis(int totalImoveis) {
		this.totalImoveis = totalImoveis;
	}

	public List<Imovel> getListaImoveis() {
		return listaImoveis;
	}

	public void setListaImoveis(List<Imovel> listaImoveis) {
		this.listaImoveis = listaImoveis;
	}

}
