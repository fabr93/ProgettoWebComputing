package it.unical.webcomp21.helloworld.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.unical.webcomp21.model.Album;
import it.unical.webcomp21.model.Podcast;
import it.unical.webcomp21.persistence.DBManager;

@Controller
public class PodcastController {
	
	
	@GetMapping("Podcast")
	public String dammiPodcast(HttpSession session, Model model) {
		
		if ( (String) session.getAttribute("usernameLogged") != null) {
			List<Podcast> listaPodcast = new ArrayList<Podcast>();
			
			listaPodcast= DBManager.getInstance().podcastDAO().findAll();
			model.addAttribute("listaPodcast", listaPodcast);
			return "Podcast";
		}
		
		else {
			return "loginError";
		}
		
		
	}
	

}
