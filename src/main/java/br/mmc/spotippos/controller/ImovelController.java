package br.mmc.spotippos.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.mmc.spotippos.exception.ImovelInvalidoException;
import br.mmc.spotippos.model.Imovel;
import br.mmc.spotippos.response.ImovelProvinciaResponse;
import br.mmc.spotippos.service.ImovelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Imovel", description = "Retorna informações relacionadas aos Imoveis.")
@RestController
@RequestMapping("/api/spotippos/imovel")
public class ImovelController {

	@Autowired
	private ImovelService imovelService;
	
	
	@ApiOperation(value = "Cria um Imovel na Provincia correspondente",
            notes = "Retorna um json com informações do imovel criado" ,
    httpMethod = "POST", response = Imovel.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Retorna com sucesso informações do imovel criado.", response = Imovel.class),
            @ApiResponse(code = 404, message = "Quando algum erro inesperado ocorre na criação do imovel.", response = Imovel.class)})
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Imovel> criarImovel(@RequestBody Imovel imovel) throws ImovelInvalidoException {
		Imovel imovelCriado = imovelService.criarImovel(imovel);
		return new ResponseEntity<Imovel>(imovelCriado, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca um Imovel na Provincia de Spotippos",
            notes = "Retorna um json com informações do imovel" ,
    httpMethod = "GET", response = Imovel.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Retorna com sucesso informações do imovel.", response = Imovel.class),
            @ApiResponse(code = 404, message = "Quando algum erro inesperado ocorre na busca do imovel.", response = Imovel.class)})
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Imovel> buscaImovel(@PathVariable("id") long id) throws ImovelInvalidoException {
		Imovel imovel = imovelService.buscaImovelId(id);
		return new ResponseEntity<Imovel>(imovel, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca todos os  Imovel em Spotippos",
            notes = "Retorna um json com informações de todos os imovel encontrado" ,
    httpMethod = "GET", response = Imovel.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Retorna com sucesso informações de todos os imoveis.", response = Imovel.class),
            @ApiResponse(code = 404, message = "Quando algum erro inesperado ocorre na busca dos imoveis.", response = Imovel.class)})
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImovelProvinciaResponse> buscaTodosImoveisProvincia(@PathParam("ax") int ax, @PathParam("ay") int ay, 
			@PathParam("bx") int bx, @PathParam("by") int by) throws ImovelInvalidoException {
		ImovelProvinciaResponse imoveis = imovelService.buscaTodosImoveisPorPosicao(ax, ay, bx, by);
		return new ResponseEntity<ImovelProvinciaResponse>(imoveis, HttpStatus.OK);
	}
	
}
