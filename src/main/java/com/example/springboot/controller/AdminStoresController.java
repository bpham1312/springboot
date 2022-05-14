package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.entity.Stores;
import com.example.springboot.service.StoresService;

@Controller
@RequestMapping(value="admin/stores")
public class AdminStoresController {
	@Autowired
	private StoresService storesService;
	
	@GetMapping(value={"","/","list"})
	public String list(Model model) {
		List<Stores> list = storesService.findAll();
		model.addAttribute("listStores", list);
		return "/admin/stores/list";
	}
	
	@PostMapping(value={"update"})
	public String update(Stores stores) {
		storesService.save(stores);
		return "redirect:/admin/stores";
	}
	
	@GetMapping(value={"edit"})
	public String edit(@RequestParam(value="id")Long id,
			Stores stores,
			Model model) {
		stores = storesService.findByID(id);
		model.addAttribute("stores", stores);
		return "/admin/stores/edit";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id")Long id) {
		storesService.deleteByID(id);
		return"redirect:/admin/stores";
	}
}
