package it.unical.webcomp21.persistence.dao;

import java.util.List;

import it.unical.webcomp21.model.Artista;

public interface ArtistaDAO {
	
	public List<Artista> findAll();
	
	public List<Artista> find(String x);

}
