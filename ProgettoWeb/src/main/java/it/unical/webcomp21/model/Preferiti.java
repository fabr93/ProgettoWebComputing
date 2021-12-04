package it.unical.webcomp21.model;

public class Preferiti {

	String id;
	String titolo;
	String artista;
	String album;
	String durata;
	boolean pre;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getDurata() {
		return durata;
	}
	public void setDurata(String durata) {
		this.durata = durata;
	}
	
	public void setPre(boolean pre) {
		this.pre = pre;
	}
	
	public boolean getPre() {
		return pre;
	}
	
}
