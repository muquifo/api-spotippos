package br.mmc.spotippos.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mmc.spotippos.enums.LimiteImovelEnum;
import br.mmc.spotippos.enums.ProvinciaEnum;
import br.mmc.spotippos.exception.ConsultaImovelException;
import br.mmc.spotippos.exception.ImovelExisteException;
import br.mmc.spotippos.exception.ImovelForaDaRegiaoException;
import br.mmc.spotippos.exception.ImovelInvalidoException;
import br.mmc.spotippos.exception.ImovelMetroQuadradoException;
import br.mmc.spotippos.exception.ImovelNaoExisteException;
import br.mmc.spotippos.key.MensagemErroKey;
import br.mmc.spotippos.model.Imovel;
import br.mmc.spotippos.repository.ImovelRepository;
import br.mmc.spotippos.response.ImovelProvinciaResponse;

@Service
public class ImovelService {
	
	@Autowired
	private ImovelRepository imovelRepository;
	
	@Autowired
	private ProvinciaService provinciaService;
	
	private static final Logger logger = Logger.getLogger(ImovelService.class);
	
	public Imovel criarImovel(Imovel imovel) throws ImovelForaDaRegiaoException, ImovelMetroQuadradoException, ImovelInvalidoException, ImovelExisteException{
			
		analisaParametrosLimites(imovel);
		
		criaPosicaoMetroQuadradoImovel(imovel);
		
		provinciaService.criaProvinciaImovel(imovel);
		
		imovelRepository.save(imovel);
			
		return imovel;
	}

	public Imovel buscaImovelId(Long id) throws ImovelNaoExisteException{

		Imovel imovel = imovelRepository.findById(id);
		
		if(imovel == null) {
			throw new ImovelNaoExisteException(MensagemErroKey.IMOVEL_NAO_EXISTE);
		}

		return imovel;
	}
	
	//TODO MONTAR REGRA PARA BUSCAR E SETAR NA LISTA TODOS OS IMOVEIS ENCONTRADO EM SPOTIPPOS
	public ImovelProvinciaResponse buscaTodosImoveisPorPosicao(int ax, int ay, int bx, int by) throws ConsultaImovelException{
		
		ImovelProvinciaResponse imovelProvinciaResponse = new ImovelProvinciaResponse();
		
		List<ProvinciaEnum> listaProvinciasEncontradas = provinciaService.getProvinciasPorPosicao(ax, ay, bx, by);
		
		if(!listaProvinciasEncontradas.isEmpty()) {
			listaProvinciasEncontradas.forEach(provinciaService -> {
				imovelProvinciaResponse.setListaImoveis(getListaImoveisPorProvincia(provinciaService));
			});
		}else {
			throw new ConsultaImovelException(MensagemErroKey.POSICAO_FORA_DA_AREA_SPOTIPPOS);
		}
		
		if(!imovelProvinciaResponse.getListaImoveis().isEmpty()) {
			imovelProvinciaResponse.setTotalImoveis(imovelProvinciaResponse.getListaImoveis().size());
			
			
			imovelProvinciaResponse.getListaImoveis().forEach(imovel ->{
				
				logger.info("IMOVEL: "+imovel.getTitulo()+" - "+imovel.getDescricao()+" - "+imovel.getProvincia().size());
				
			});
			
		}else {
			throw new ConsultaImovelException(MensagemErroKey.NENHUM_IMOVEL_ENCONTRADO);
		}
		
		return imovelProvinciaResponse;
	}

	public List<Imovel> getListaImoveisPorProvincia(ProvinciaEnum provinciaEnum){
		return imovelRepository.findByProvincia(provinciaEnum);
	}
	
	private void analisaParametrosLimites(Imovel imovel) {
		if(imovelRepository.findById(imovel.getId()) != null) {
			throw new ImovelExisteException(MensagemErroKey.IMOVEL_JA_EXISTE);
		}
		if(imovel.getBanheiro() < LimiteImovelEnum.BANHEIRO.getMin() || imovel.getBanheiro() > LimiteImovelEnum.BANHEIRO.getMax()) {
			throw new ImovelInvalidoException(MensagemErroKey.BANHEIRO_FORA_DO_LIMITE);
		}
		if(imovel.getQuarto() < LimiteImovelEnum.QUARTO.getMin() || imovel.getQuarto() > LimiteImovelEnum.QUARTO.getMax()) {
			throw new ImovelInvalidoException(MensagemErroKey.QUARTO_FORA_DO_LIMITE);
		}
		if(imovel.getPosicaoX() < LimiteImovelEnum.POSICAO_X.getMin() || imovel.getPosicaoX() > LimiteImovelEnum.POSICAO_X.getMax()) {
			throw new ImovelInvalidoException(MensagemErroKey.POSISAO_X_FORA_DO_LIMITE);
		}
		if(imovel.getPosicaoY() < LimiteImovelEnum.POSICAO_Y.getMin() || imovel.getPosicaoY() > LimiteImovelEnum.POSICAO_Y.getMax()) {
			throw new ImovelInvalidoException(MensagemErroKey.POSISAO_Y_FORA_DO_LIMITE);
		}
		if(imovel.getMetroQuadrado() <= LimiteImovelEnum.METRO_QUADRADO.getMin() || imovel.getMetroQuadrado() > LimiteImovelEnum.METRO_QUADRADO.getMax()) {
			throw new ImovelInvalidoException(MensagemErroKey.METRO_QUADRADO_NAO_PERMITIDO);
		}
	}

	private void criaPosicaoMetroQuadradoImovel(Imovel imovel) {
		
		double ladoImovel = Math.sqrt(imovel.getMetroQuadrado());
		double posicaoAX = imovel.getPosicaoX();
		double posicaoAY = imovel.getPosicaoY();
		double posicaoBX = (posicaoAX + ladoImovel);
		double posicaoBY = (posicaoAY + ladoImovel);
		
		imovel.setPosicaoAX((int)posicaoAX);
		imovel.setPosicaoAY((int)posicaoAY);
		imovel.setPosicaoBX((int)posicaoBX);
		imovel.setPosicaoBY((int)posicaoBY);
	}

}
