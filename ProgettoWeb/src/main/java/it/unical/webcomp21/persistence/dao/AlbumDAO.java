package it.unical.webcomp21.persistence.dao;

import java.util.List;

import it.unical.webcomp21.model.Album;

public interface AlbumDAO {
	
	public List<Album> findAll();
	
	public List<Album> find(String x);

	
}
