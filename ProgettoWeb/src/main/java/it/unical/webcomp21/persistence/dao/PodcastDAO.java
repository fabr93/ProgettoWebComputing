package it.unical.webcomp21.persistence.dao;

import java.util.List;

import it.unical.webcomp21.model.Podcast;

public interface PodcastDAO {
	
	public List<Podcast> findAll();
	
	public List<Podcast> find(String x);

}
