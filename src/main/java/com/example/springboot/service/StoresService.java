package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Stores;
import com.example.springboot.repo.StoresDAO;

@Service
public class StoresService {
	@Autowired
	private StoresDAO storesDAO;
	
	public List<Stores> findAll(){
		return storesDAO.findAll();
	}
	
	public Stores findByID(Long id) {
		return storesDAO.findById(id).get();
	}
	
	public String deleteByID(Long id) {
		storesDAO.deleteById(id);
		return "delete"+id;
	}
	
	public Stores save(Stores stores) {
		Stores existCats = new Stores();
		if(stores.getId()!=null) {
			existCats.setId(stores.getId());		
		}
		existCats.setQuantity(stores.getQuantity());
		existCats.setPrice(stores.getPrice());
//		existCats.setCats(stores.getCats());
		return storesDAO.save(existCats);
	}
}
