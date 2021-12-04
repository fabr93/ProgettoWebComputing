package it.unical.webcomp21.persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unical.webcomp21.model.Artista;
import it.unical.webcomp21.model.Playlist;
import it.unical.webcomp21.model.Preferiti;
import it.unical.webcomp21.persistence.DBSource;
import it.unical.webcomp21.persistence.dao.ArtistaDAO;

public class ArtistaDAOJDBC implements ArtistaDAO {
	DBSource dbSource;
	
	public ArtistaDAOJDBC(DBSource dbSource) {
		this.dbSource= dbSource;
	}

	@Override
	public List<Artista> findAll() {
		List<Artista> artista = new ArrayList<Artista>();
		
		try {
			Connection conn= dbSource.getConnection();
			String query ="select * from artista";
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next()) {
				String nome= rs.getString("nome");
				String sfondo= rs.getString("sfondo");
				
				
				Artista art= new Artista();
				art.setNome(nome);
				art.setSfondo(sfondo);
				
				
				artista.add(art);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artista;
		
		
		
		
		
	}

	@Override
	public List<Artista> find(String x) {
		List<Artista> artisti = new ArrayList<Artista>();
		
		String query ="SELECT * FROM tuttiartisti WHERE nome = ?;";
	
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
			
			
			
			Artista art= new Artista();
			
			art.setNome(nome);
			art.setSfondo(sfondo);
			
			
			
			artisti.add(art);
		}	
		st.close();
		con.close();
		
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		}
	
	
	
	
	
	return artisti;
	}
	

}
