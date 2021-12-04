package it.unical.webcomp21.helloworld.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.unical.webcomp21.model.Album;
import it.unical.webcomp21.model.Playlist;
import it.unical.webcomp21.persistence.DBManager;

@Controller
public class AlbumController {
	
	
	@GetMapping("Album")
	public String dammiAlbum(HttpSession session, Model model) {
		
		if ( (String) session.getAttribute("usernameLogged") != null) {
			List<Album> listaAlbum = new ArrayList<Album>();
			
			listaAlbum= DBManager.getInstance().albumDAO().findAll();
			model.addAttribute("listaAlbum", listaAlbum);
			return "Album";
		}
		
		else {
			return "loginError";
		}
	}

}
