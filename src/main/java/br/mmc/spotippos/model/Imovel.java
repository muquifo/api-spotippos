package br.mmc.spotippos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.mmc.spotippos.enums.ProvinciaEnum;

@Table(name="imovel")
@Entity
public class Imovel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cd_id")
	private Long id;

	@Column(name="nm_titulo")
	private String titulo;
	
	@Column(name="ds_imovel")
	private String descricao;
	
	@Column(name="cd_posicao_x")
	private int posicaoX;
	
	@Column(name="cd_posicao_y")
	private int posicaoY;
	
	@Column(name="vl_preco")
	private long preco;
	
	@Column(name="qt_quarto")
	private int quarto;
	
	@Column(name="qt_banheiro")
	private int banheiro;
	
	@Column(name="vl_metro_quadrado")
	private int metroQuadrado;
	
	@Column(name="cd_posisao_ax")
	private int posicaoAX;
	
	@Column(name="cd_posisao_ay")
	private int posicaoAY;
	
	@Column(name="cd_posisao_bx")
	private int posicaoBX;
	
	@Column(name="cd_posisao_by")
	private int posicaoBY;
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private List<ProvinciaEnum> provincia;
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}

	public long getPreco() {
		return preco;
	}

	public void setPreco(long preco) {
		this.preco = preco;
	}

	public int getQuarto() {
		return quarto;
	}

	public void setQuarto(int quarto) {
		this.quarto = quarto;
	}

	public int getBanheiro() {
		return banheiro;
	}

	public void setBanheiro(int banheiro) {
		this.banheiro = banheiro;
	}

	public int getMetroQuadrado() {
		return metroQuadrado;
	}

	public void setMetroQuadrado(int metroQuadrado) {
		this.metroQuadrado = metroQuadrado;
	}

	public int getPosicaoAX() {
		return posicaoAX;
	}

	public void setPosicaoAX(int posicaoAX) {
		this.posicaoAX = posicaoAX;
	}

	public int getPosicaoAY() {
		return posicaoAY;
	}

	public void setPosicaoAY(int posicaoAY) {
		this.posicaoAY = posicaoAY;
	}

	public int getPosicaoBX() {
		return posicaoBX;
	}

	public void setPosicaoBX(int posicaoBX) {
		this.posicaoBX = posicaoBX;
	}

	public int getPosicaoBY() {
		return posicaoBY;
	}

	public void setPosicaoBY(int posicaoBY) {
		this.posicaoBY = posicaoBY;
	}

	public List<ProvinciaEnum> getProvincia() {
		return provincia;
	}

	public void setProvincia(List<ProvinciaEnum> provincia) {
		this.provincia = provincia;
	}

}
