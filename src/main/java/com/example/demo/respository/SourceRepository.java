package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Source;


public interface SourceRepository extends JpaRepository<Source, Long>{

}
