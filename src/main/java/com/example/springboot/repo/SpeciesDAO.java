package com.example.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Species;

@Repository
public interface SpeciesDAO extends JpaRepository<Species, Long>{

}
