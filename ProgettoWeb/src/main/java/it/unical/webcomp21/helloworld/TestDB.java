package it.unical.webcomp21.helloworld;

import java.util.List;

import it.unical.webcomp21.model.Playlist;
import it.unical.webcomp21.persistence.DBManager;
import it.unical.webcomp21.persistence.dao.PlaylistDAO;

public class TestDB {

	
	public static void main(String[] args) {
		
		
		PlaylistDAO playlist= DBManager.getInstance().playlistDAO();
		
		
		List<Playlist> l = playlist.findAll();
		for (Playlist p : l) {
			System.out.println(p.getNome());
		}
		
	}
}
