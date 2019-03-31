package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Departement;
import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String str);
    List<User> findByDepartement(Departement departement);
}