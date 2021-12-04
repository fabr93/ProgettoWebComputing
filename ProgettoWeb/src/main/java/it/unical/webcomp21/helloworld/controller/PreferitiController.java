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
public class PreferitiController {
	
	@GetMapping("Preferiti")
	public String dammiPreferiti(HttpSession session, Model model) {
		
		if( (String) session.getAttribute("usernameLogged") != null) {
			List<Preferiti> listaPreferiti = new ArrayList<Preferiti>();
			
			listaPreferiti= DBManager.getInstance().preferitiDAO().findAll();
			model.addAttribute("listaPreferiti", listaPreferiti);
			return "Preferiti";
			
		}
		
		else {
			return "loginError";
		}
	}
	
	
	@PostMapping("/rimuovi")
	@ResponseBody
	public String rimuovi(Model model, HttpSession session, @RequestParam String id ) {
		
		
		DBManager.getInstance().preferitiDAO().remove(id);
		
		return "ok";
	}
	

}
