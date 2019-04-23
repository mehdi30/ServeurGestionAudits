package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Departement;
import com.example.demo.entity.User;
import com.example.demo.respository.UserRepository;

@Service
@Primary
public class UserService implements ICrudService<User, Long>{

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	public User getByIdprojet(Long id) {
		
		return userRepository.findByProjetsId(id);
		
	}

	
	public List<User> getAllUserByDepartement(Long id) {
		Departement departement = new Departement();
		departement.setIdDep(id);
		return userRepository.findByDepartement(departement);
	}
	
	@Override
	public void add(User user) {
		userRepository.save(user);
	}

	@Override
	public void update(User user) {
		userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		User user = new User();
		user.setId(id);
		userRepository.delete(user);
	}

	

}