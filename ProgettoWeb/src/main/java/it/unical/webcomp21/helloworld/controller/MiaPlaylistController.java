package it.unical.webcomp21.helloworld.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.webcomp21.model.Preferiti;
import it.unical.webcomp21.persistence.DBManager;

@Controller
public class MiaPlaylistController {
	
	/*
	@GetMapping("MiaPlaylist")
	public String dammiPlaylist(HttpSession session, Model model) {
		
		
		if ( (String) session.getAttribute("usernameLogged") != null) {
		List<Preferiti> listaPlaylist = new ArrayList<Preferiti>();
		
		listaPlaylist= DBManager.getInstance().preferitiDAO().findAll();
		model.addAttribute("listaPlaylist", listaPlaylist);
		return "MiaPlaylist";
	}
	
		else {
			return "loginError";
		}


	}
	*/
	
	@PostMapping("/loadPlaylist")
	@ResponseBody
	public String loadPlaylist(Model model, HttpSession session, @RequestParam String id ) {
		
		
		DBManager.getInstance().preferitiDAO().remove(id);
		// DBManager.getInstance().miaPlaylistDAO().find(id); 
		return "ok";
	}
	
	
}
