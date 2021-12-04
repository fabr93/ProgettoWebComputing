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
import it.unical.webcomp21.model.Preferiti;
import it.unical.webcomp21.persistence.DBSource;
import it.unical.webcomp21.persistence.dao.PreferitiDAO;

public class PreferitiDAOJDBC implements PreferitiDAO{
	DBSource dbSource;

	
	public PreferitiDAOJDBC(DBSource dbSource) {
		this.dbSource= dbSource;
	}
	
	
	
	@Override
	public List<Preferiti> findAll() {
		List<Preferiti> preferiti= new ArrayList<Preferiti>();
		
		try {
			Connection conn= dbSource.getConnection();
			String query ="select * from preferiti";
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next()) {
				String id= rs.getString("id");
				
				String query2 ="select * from tuttibrani WHERE id= ?";
				PreparedStatement st2 = conn.prepareStatement(query2);
				st2.setInt(1, Integer.parseInt(id));
				st2.execute();			
				
				ResultSet rs2= st2.getResultSet();
				if(rs2.next()) {
				String titolo= rs2.getString("titolo");
				String artista= rs2.getString("artista");
				String album= rs2.getString("album");
				String durata= rs2.getString("durata");
				
				
				Preferiti pre= new Preferiti();
				pre.setId(id);
				pre.setTitolo(titolo);
				pre.setArtista(artista);
				pre.setAlbum(album);
				pre.setDurata(durata);
				
				
				preferiti.add(pre);
				}
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return preferiti;
		
		
	}



	@Override
	public void remove(String id) {
		int idInt = Integer.parseInt(id);
		
		String query ="DELETE FROM preferiti WHERE id = ?;";
		
		Connection con;
		
		try {
			con = dbSource.getConnection();
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, idInt);
			st.execute();
			
			st.close();
			con.close();
			
			
		} catch (SQLException e) {System.out.println(e.getMessage());}
		
	}



	@Override
	public List<Preferiti> find(String x) {
		List<Preferiti> brani = new ArrayList<Preferiti>();
		
		String query ="SELECT * FROM tuttibrani WHERE titolo = ?;";
	
		Connection con;
	
	try {
		con = dbSource.getConnection();
		
		
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, x);
		st.execute();			
		
		ResultSet rs= st.getResultSet();
		while(rs.next()) {
			
			String id= rs.getString("id");
			String titolo= rs.getString("titolo");
			String artista= rs.getString("artista");
			String album= rs.getString("album");
			String durata= rs.getString("durata");
			
			
			String query2  ="SELECT * FROM preferiti WHERE id = ?;";
			PreparedStatement st2 = con.prepareStatement(query2);
			int id2 = Integer.parseInt(id);
			st2.setInt(1, id2);
			st2.execute();			
			ResultSet rs2= st2.getResultSet();
			
			boolean pref = false;
			if(rs2.next()) {
				 pref = true;
			}
			
			st2.close();
			
			
			
			Preferiti pre= new Preferiti();
			pre.setId(id);
			pre.setTitolo(titolo);
			pre.setArtista(artista);
			pre.setAlbum(album);
			pre.setDurata(durata);
			
			pre.setPre(pref);
			
			brani.add(pre);
		}	
		st.close();
		con.close();
		
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		}
	
	
	
	
	
	return brani;
	}



	@Override
	public void add(String id) {
		String query ="INSERT INTO preferiti VALUES(?);";
		
		Connection con;
		
		
		try {
			
			con = dbSource.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			
			st.setInt(1, Integer.parseInt(id));
			
			
			st.execute();
			
			
			st.close();
			con.close();
			
			
		}
		
		catch(SQLException e){System.out.println(e.getMessage());}
		
	}

}
