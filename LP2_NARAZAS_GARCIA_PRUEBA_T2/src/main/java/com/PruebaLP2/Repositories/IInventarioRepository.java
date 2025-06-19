package com.PruebaLP2.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PruebaLP2.Models.*;


public interface IInventarioRepository extends JpaRepository<Inventario, Integer> {
	
	@Query(" select in from Inventario in"
			+ " join fetch in.producto pr "
			+ "join fetch pr.categoria cat "
			+ "order by in.numero desc")
	List<Inventario> listaInventario();
}
