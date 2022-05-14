package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.entity.Cats;
import com.example.springboot.entity.Species;
import com.example.springboot.entity.Stores;
import com.example.springboot.service.CatsService;
import com.example.springboot.service.SpeciesService;
import com.example.springboot.service.StoresService;

@Controller
@RequestMapping(value="admin/cats")
public class AdminCatsController {
	
	@Autowired
	private CatsService catsService;
	@Autowired
	private SpeciesService speciesService;
	@Autowired
	private StoresService storesService;
	
	@GetMapping(value= {"","/","list"})
	public String list(Model model) {
		List<Cats> list = catsService.findAll();
		model.addAttribute("listCats", list);
		return "/admin/cats/list";
	}
	
	@GetMapping(value= {"update"})
	public String add(Model model) {
		List<Species> species =	speciesService.findAll();
		model.addAttribute("listSpecies", species);
		return "/admin/cats/new";
	}
	
	@PostMapping(value= {"update"})
	public String update(@RequestParam(value="new", required=false)String newSpecies,
			@RequestParam(value="selectSpecies", required=false)Long id,
			Species species,
			Cats cats,
			Stores stores,
			Model model) {
		if(!newSpecies.isEmpty()) {
			species.setName(newSpecies);
			species = speciesService.save(species);
			species = speciesService.findByID(species.getId());
		}else {
			species.setId(id);
		}
		
		cats.setSpecies(species);
		cats = catsService.save(cats);
		stores.setId(cats.getId()); 
		storesService.save(stores);
		return "redirect:/admin/cats";
	}
	
	@GetMapping(value= {"edit"})
	public String edit(@ModelAttribute("stores")Stores stores,
			@RequestParam("id")Long id,
			Cats cats,
			Model model) {
		List<Species> species =	speciesService.findAll();
		model.addAttribute("listSpecies", species);
		cats = catsService.findByID(id);
		model.addAttribute("cats", cats);
		return "/admin/cats/edit";
	}
	
	@GetMapping(value= {"delete"})
	public String delete(@RequestParam("id")Long id) {
		catsService.deleteByID(id);
		return "redirect:/admin/cats";
	}
}
