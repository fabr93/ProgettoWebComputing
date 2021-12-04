package it.unical.webcomp21.persistence;

import it.unical.webcomp21.persistence.dao.AlbumDAO;
import it.unical.webcomp21.persistence.dao.ArtistaDAO;
import it.unical.webcomp21.persistence.dao.PlaylistDAO;
import it.unical.webcomp21.persistence.dao.PodcastDAO;
import it.unical.webcomp21.persistence.dao.PreferitiDAO;
import it.unical.webcomp21.persistence.dao.jdbc.AlbumDAOJDBC;
import it.unical.webcomp21.persistence.dao.jdbc.ArtistaDAOJDBC;
import it.unical.webcomp21.persistence.dao.jdbc.PlaylistDAOJDBC;
import it.unical.webcomp21.persistence.dao.jdbc.PodcastDAOJDBC;
import it.unical.webcomp21.persistence.dao.jdbc.PreferitiDAOJDBC;

public class DBManager {
	private static DBManager instance = null;
	static DBSource dataSource;
	
	static {
		try {
			
			Class.forName("org.postgresql.Driver");
			//questi vanno messi in file di configurazione!!!
			//Dal progetto proprietà/Java Build Path/Libraries/Modulepath --> Add JARs quella che si trova nella cartella lib
			
			
			dataSource=new DBSource("jdbc:postgresql://localhost:5432/musica","postgres","postgres");
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager() {
	}
	
	public static DBSource getDataSource() {
		return dataSource;
	}
	
	public PlaylistDAO playlistDAO() {
		return new PlaylistDAOJDBC(dataSource);
	}
	
	public ArtistaDAO artistaDAO() {
		return new ArtistaDAOJDBC(dataSource);
	}

	public AlbumDAO albumDAO() {
		return new AlbumDAOJDBC(dataSource);
	}
	
	public PodcastDAO podcastDAO() {
		return new PodcastDAOJDBC(dataSource);
	}

	public PreferitiDAO preferitiDAO() {
		return new PreferitiDAOJDBC(dataSource);
	}
}

