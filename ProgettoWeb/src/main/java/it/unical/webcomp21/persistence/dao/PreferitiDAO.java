package it.unical.webcomp21.persistence.dao;

import java.util.List;

import it.unical.webcomp21.model.Preferiti;

public interface PreferitiDAO {
	
	public List<Preferiti> findAll();
	void remove (String id);
	
	
	public List<Preferiti> find(String x);
	public void add(String id);
}
