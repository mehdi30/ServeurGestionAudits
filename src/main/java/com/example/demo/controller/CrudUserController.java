package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.respository.RoleRepository;
import com.example.demo.respository.UserRepository;
import com.example.demo.service.ICrudService;
import com.example.demo.service.UserService;
import com.example.demo.util.RoleEnum;


@RestController
@RequestMapping("/crud_user")
//@CrossOrigin
public class CrudUserController extends CrudController<User, Long>{

	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserService userService;
	@Override
	public List<User> getAll(){
		List<User> users = super.getAll();
		users.forEach(user -> user.setPassword(null));
		users.forEach(user -> user.getDepartement());

		return users;
	}
	
	@Override
	public void add(@RequestBody User user) {
		Role role = roleRepository.findByName(RoleEnum.ROLE_USER.getName());
		user.setRoles(Arrays.asList(role));
		user.setEnable(true);
		LocalDateTime currentDate = LocalDateTime.now();
        user.setCreation(currentDate);
		super.add(user);
	}
	
	  @RequestMapping(value = "/departement/{depId}", method = RequestMethod.GET)
	    public List<User> getDepartement(@PathVariable("depId") Long depId) {
	    	return userService.getAllUserByDepartement(depId);
	       
	    }
	  
	  @RequestMapping(value = "/current", method = RequestMethod.GET)
	    public User getByUsername() {
		  Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = ((UserDetails)principal).getUsername();
	    	return userService.getByUsername(username);
	       
	    }
	  

	  @RequestMapping(value = "/projet/{id}", method = RequestMethod.GET)
	    public User getByProjet(@PathVariable("id") Long id) {
	    	return userService.getByIdprojet(id);
	       
	    }
	  
	  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	    public Optional<User> getByid(@PathVariable("id") Long id) {
	    	return userService.getById(id);
	       
	    }
}
