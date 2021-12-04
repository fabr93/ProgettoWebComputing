package it.unical.webcomp21.helloworld.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.webcomp21.model.Album;
import it.unical.webcomp21.model.Artista;
import it.unical.webcomp21.model.Playlist;
import it.unical.webcomp21.model.Podcast;
import it.unical.webcomp21.model.Preferiti;
import it.unical.webcomp21.persistence.DBManager;

@Controller
public class Home {
	
	@GetMapping("/")
	public String home() {
		return "index";
			}
	
	
	@GetMapping("Search")
	public String getSearch(HttpSession session, @RequestParam String s, Model model) {
			
			String[] search = s.split(",");
			String daCercare= search[0];
			
			
			List<Preferiti> canzoni =  DBManager.getInstance().preferitiDAO().find(daCercare);
			model.addAttribute("canzoni",canzoni);
			int c=canzoni.size();
			if( c>0)
				model.addAttribute("c",c);
			
			
			
			List<Artista> artisti= DBManager.getInstance().artistaDAO().find(daCercare);
			model.addAttribute("artisti", artisti);
			int a=artisti.size();
			if( a>0)
				model.addAttribute("a",a);
			
			
			
			List<Album> album= DBManager.getInstance().albumDAO().find(daCercare);
			model.addAttribute("album", album);
			int aa=album.size();
			if( aa>0)
				model.addAttribute("aa",aa);
			
			
			
			List<Playlist> playlist= DBManager.getInstance().playlistDAO().find(daCercare);
			model.addAttribute("playlist", playlist);
			int p=playlist.size();
			if( p>0)
				model.addAttribute("p",p);
			
			
			List<Podcast> podcast= DBManager.getInstance().podcastDAO().find(daCercare);
			model.addAttribute("podcast", podcast);
			int pp=podcast.size();
			if( pp>0)
				model.addAttribute("pp",p);
			
			
			if( c==0 & a==0 & aa==0 & p==0 & pp==0)
				model.addAttribute("vuoto", 1);
			
			
			return "index";
	}
	
	
	@PostMapping("/remove")
	@ResponseBody
	public String remove(Model model, HttpSession session, @RequestParam String id ) {
		
		
		DBManager.getInstance().preferitiDAO().remove(id);
		
		return "ok";
	}
	
	
	@PostMapping("/add")
	@ResponseBody
	public String add(Model model, HttpSession session, @RequestParam String id) {
		
		
		DBManager.getInstance().preferitiDAO().add(id);
		
		return "ok";
	}
	
	
	
}
