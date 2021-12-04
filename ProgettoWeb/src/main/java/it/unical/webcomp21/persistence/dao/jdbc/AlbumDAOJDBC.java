package it.unical.webcomp21.persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unical.webcomp21.model.Album;
import it.unical.webcomp21.model.Artista;
import it.unical.webcomp21.persistence.DBSource;
import it.unical.webcomp21.persistence.dao.AlbumDAO;

public class AlbumDAOJDBC implements AlbumDAO{
	DBSource dbSource;
	
	public AlbumDAOJDBC(DBSource dbSource) {
		this.dbSource= dbSource;
	}

	@Override
	public List<Album> findAll() {
		List<Album> album = new ArrayList<Album>();
		
		try {
			Connection conn= dbSource.getConnection();
			String query ="select * from album";
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next()) {
				String nome= rs.getString("nome");
				String sfondo= rs.getString("sfondo");
				
				
				Album alb= new Album();
				alb.setNome(nome);
				alb.setSfondo(sfondo);
				
				
				album.add(alb);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return album;
			
	
	}

	@Override
	public List<Album> find(String x) {
		List<Album> album = new ArrayList<Album>();
		
		String query ="SELECT * FROM tuttialbum WHERE nome = ?;";
	
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
			
			
			
			Album alb= new Album();
			
			alb.setNome(nome);
			alb.setSfondo(sfondo);
			
			
			
			album.add(alb);
		}	
		st.close();
		con.close();
		
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		}
	
	
	
	
	
	return album;
	}

}
