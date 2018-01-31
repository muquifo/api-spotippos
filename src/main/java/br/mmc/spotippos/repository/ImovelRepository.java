package br.mmc.spotippos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mmc.spotippos.enums.ProvinciaEnum;
import br.mmc.spotippos.model.Imovel;

@Repository 
public interface ImovelRepository extends JpaRepository<Imovel, Long>{
	Imovel findById(Long id);
	List<Imovel> findByProvincia(ProvinciaEnum provinciaEnum);
}
