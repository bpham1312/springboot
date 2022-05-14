package com.example.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Stores;

@Repository
public interface StoresDAO extends JpaRepository<Stores, Long>{

}
