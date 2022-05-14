package com.example.springboot.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Species;
import com.example.springboot.repo.SpeciesDAO;

@Service
public class SpeciesService {
	@Autowired
	private SpeciesDAO speciesDAO;
	
	
	public List<Species> findAll(){
		return speciesDAO.findAll();
	}
	
	public Species findByID(Long id) {
		return speciesDAO.findById(id).get();
	}
	
	public String deleteByID(Long id) {
		speciesDAO.deleteById(id);
		return "delete"+id;
	}
	
	public Species save(Species species) {
		Species existSpecies = new Species();
		if(species.getId()!=null) {
			existSpecies.setId(species.getId());		
		}
		existSpecies.setName(species.getName());
		return speciesDAO.save(existSpecies);
	}
}
