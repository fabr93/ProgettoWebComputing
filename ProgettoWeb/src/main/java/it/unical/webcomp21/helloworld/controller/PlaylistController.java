package it.unical.webcomp21.helloworld.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.unical.webcomp21.model.Playlist;
import it.unical.webcomp21.persistence.DBManager;

@Controller
public class PlaylistController {
	
	@GetMapping("Playlist")
	public String dammiPlaylist(HttpSession session, Model model) {
		
		
		if ( (String) session.getAttribute("usernameLogged") != null) {
		List<Playlist> listaPlaylist = new ArrayList<Playlist>();
		
		listaPlaylist= DBManager.getInstance().playlistDAO().findAll();
		model.addAttribute("listaPlaylist", listaPlaylist);
		return "Playlist";
	}
	
		else {
			return "loginError";
		}


	}
	
	
}
