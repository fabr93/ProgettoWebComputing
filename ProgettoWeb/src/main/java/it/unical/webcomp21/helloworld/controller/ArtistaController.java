package it.unical.webcomp21.helloworld.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.unical.webcomp21.model.Artista;
import it.unical.webcomp21.persistence.DBManager;

@Controller
public class ArtistaController {
	
	
	
	@GetMapping("Artista")
	public String dammiArtista(HttpSession session, Model model) {
		
		if( (String) session.getAttribute("usernameLogged") != null) {
			List<Artista> listaArtista = new ArrayList<Artista>();
			
			listaArtista= DBManager.getInstance().artistaDAO().findAll();
			model.addAttribute("listaArtista", listaArtista);
			return "Artista";
		}
		
		else {
			return "loginError";
		}
		
		
		
		
		
	}

}
