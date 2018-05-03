package br.mmc.spotippos.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mmc.spotippos.enums.ProvinciaEnum;
import br.mmc.spotippos.exception.ImovelMetroQuadradoException;
import br.mmc.spotippos.key.MensagemErroKey;
import br.mmc.spotippos.model.Imovel;

@Service
public class ProvinciaService {
	
	private static final Logger logger = Logger.getLogger(ProvinciaService.class);
	
	@Autowired
	private ImovelService imovelService;
	
	public void criaProvinciaImovel(Imovel imovel) throws ImovelMetroQuadradoException{
		
		imovel.setProvincia( getProvinciasPorPosicao(imovel.getPosicaoAX(), imovel.getPosicaoAY(), imovel.getPosicaoBX(), imovel.getPosicaoBY()) );
		
		verificaSePodeSerCriadoNaProvinciaPorMetroQuadrado(imovel);
		
	}

	public List<ProvinciaEnum> getProvinciasPorPosicao(int posicaoAX, int posicaoAY, int posicaoBX, int posicaoBY) {
		
		List<ProvinciaEnum> listaProvincia = new ArrayList<ProvinciaEnum>();
		
		List<ProvinciaEnum> provinciaEnumList = Arrays.asList(ProvinciaEnum.values());
		
		provinciaEnumList.forEach(provincia -> {
			
			if(posicaoAX >= provincia.getAx() && posicaoAY <= provincia.getAy() 
					&& posicaoBX <= provincia.getBx() && posicaoBY >= provincia.getBy()) {
				
				listaProvincia.add(provincia);
				
			}
		});
		
		return listaProvincia;
	}

	private void verificaSePodeSerCriadoNaProvinciaPorMetroQuadrado(Imovel imovel) {
		
		List<Imovel> imoveisEncontradoList = new ArrayList<Imovel>();
		
		imovel.getProvincia().forEach(provinciaEnum ->{
			imoveisEncontradoList.addAll( imovelService.getListaImoveisPorProvincia(provinciaEnum) );
		});
		
		if(!imoveisEncontradoList.isEmpty()) {
			
			imoveisEncontradoList.forEach(imovelCriado ->{
				
				if(imovel.getPosicaoAX() >= imovelCriado.getPosicaoAX() && imovel.getPosicaoAY() <= imovelCriado.getPosicaoAY() 
						&& imovel.getPosicaoBX() <= imovelCriado.getPosicaoBX() && imovel.getPosicaoBY() >= imovelCriado.getPosicaoBY()) {
					
					throw new ImovelMetroQuadradoException(MensagemErroKey.IMOVEL_JA_CRIADO_NO_MESMO_LOCAL);
					
				}
			});
		}
	}

}
