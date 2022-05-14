package com.example.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Cats;

@Repository
public interface CatsDAO extends JpaRepository<Cats, Long>{

}
