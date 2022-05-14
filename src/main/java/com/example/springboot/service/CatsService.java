package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Cats;
import com.example.springboot.repo.CatsDAO;

@Service
public class CatsService {
	@Autowired
	private CatsDAO catsDAO;
	
	
	public List<Cats> findAll(){
		return catsDAO.findAll();
	}
	
	public Cats findByID(Long id) {
		return catsDAO.findById(id).get();
	}
	
	public String deleteByID(Long id) {
		catsDAO.deleteById(id);;
		return "delete"+id;
	}
	
	public Cats save(Cats cats) {
		Cats existCats = new Cats();
		if(cats.getId()!=null) {
			existCats.setId(cats.getId());		
		}
		existCats.setName(cats.getName());
		existCats.setDescription(cats.getDescription());
		existCats.setSpecies(cats.getSpecies());
		return catsDAO.save(existCats);
	}


}
