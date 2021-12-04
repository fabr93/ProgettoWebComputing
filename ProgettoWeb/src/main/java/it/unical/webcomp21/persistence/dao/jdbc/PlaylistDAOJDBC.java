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
import it.unical.webcomp21.persistence.DBSource;
import it.unical.webcomp21.persistence.dao.PlaylistDAO;

public class PlaylistDAOJDBC implements PlaylistDAO{
	DBSource dbSource;
	
	public PlaylistDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}
	
	
	

	@Override
	public List<Playlist> findAll() {
		List<Playlist> playlist = new ArrayList<Playlist>();
		
		try {
			Connection conn= dbSource.getConnection();
			String query ="select * from playlist";
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next()) {
				String nome= rs.getString("nome");
				String sfondo= rs.getString("sfondo");
				
				
				Playlist play= new Playlist();
				play.setNome(nome);
				play.setSfondo(sfondo);
				
				
				playlist.add(play);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return playlist;
		
			
	
	}




	@Override
	public List<Playlist> find(String x) {
		List<Playlist> playlist = new ArrayList<Playlist>();
		
		String query ="SELECT * FROM tuttiplaylist WHERE nome = ?;";
	
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
			
			
			
			Playlist play= new Playlist();
			
			play.setNome(nome);
			play.setSfondo(sfondo);
			
			
			
			playlist.add(play);
		}	
		st.close();
		con.close();
		
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		}
	
	
	
	
	
	return playlist;
	}
	
}
