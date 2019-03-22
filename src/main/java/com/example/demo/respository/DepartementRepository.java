package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long>{

}
