package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Long>{

}
