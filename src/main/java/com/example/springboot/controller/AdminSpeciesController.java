package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springboot.entity.Species;
import com.example.springboot.service.SpeciesService;

@Controller
@RequestMapping(value="/admin/species")
public class AdminSpeciesController {
	@Autowired
	private SpeciesService speciesService;
	
	@GetMapping({"/list","","/"})
	public String list(Model model) {
		List<Species> species =	speciesService.findAll();
		model.addAttribute("listSpecies", species);
		return"admin/species/list";
	}
	@GetMapping("/update")
		public String add() {
		return"admin/species/new";
	}
	@PostMapping("/update")
	public String update(Species species ,Model model) {
		speciesService.save(species);
		return"redirect:/admin/species";
	}
	@GetMapping("/edit")
	public String edit(@RequestParam("id")Long id , Model model,
			RedirectAttributes r) {
		Species species = speciesService.findByID(id);
		model.addAttribute("species", species);
		return"/admin/species/edit";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("id")Long id) {
		speciesService.deleteByID(id);
		return"redirect:/admin/species";
	}
}
