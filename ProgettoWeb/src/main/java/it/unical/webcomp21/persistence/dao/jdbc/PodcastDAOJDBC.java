package it.unical.webcomp21.persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unical.webcomp21.model.Album;
import it.unical.webcomp21.model.Playlist;
import it.unical.webcomp21.model.Podcast;
import it.unical.webcomp21.persistence.DBSource;
import it.unical.webcomp21.persistence.dao.PodcastDAO;

public class PodcastDAOJDBC implements PodcastDAO {
	DBSource dbSource;
	
	public PodcastDAOJDBC(DBSource dbSource) {
		this.dbSource= dbSource;
	}

	@Override
	public List<Podcast> findAll() {
		List<Podcast> podcast = new ArrayList<Podcast>();
		
		try {
			Connection conn= dbSource.getConnection();
			String query ="select * from podcast";
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next()) {
				String nome= rs.getString("nome");
				String sfondo= rs.getString("sfondo");
				
				
				Podcast pod= new Podcast();
				pod.setNome(nome);
				pod.setSfondo(sfondo);
				
				
				podcast.add(pod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return podcast;
	}

	@Override
	public List<Podcast> find(String x) {
		List<Podcast> podcast = new ArrayList<Podcast>();
		
		String query ="SELECT * FROM tuttipodcast WHERE nome = ?;";
	
		Connection con;
	
	try {
		con = dbSource.getConnection();
		
		
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, x);
		st.execute();			
		
		ResultSet rs= st.getResultSet();
		while(rs.next()) {
			
			String nome= rs.getString("nome");
			String sfondo= rs.getString("sfondo");
			
			
			
			Podcast pod= new Podcast();
			
			pod.setNome(nome);
			pod.setSfondo(sfondo);
			
			
			
			podcast.add(pod);
		}	
		st.close();
		con.close();
		
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		}
	
	
	
	
	
	return podcast;
	}

}
