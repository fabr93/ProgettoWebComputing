package it.unical.webcomp21.persistence.dao;

import java.util.List;

import it.unical.webcomp21.model.Playlist;

public interface PlaylistDAO {
	public List<Playlist> findAll();
	public List<Playlist> find(String x);

}
