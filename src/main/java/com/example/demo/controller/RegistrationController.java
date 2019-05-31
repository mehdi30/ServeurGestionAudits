package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.respository.UserRepository;
import com.example.demo.service.MailService;

@RestController
public class RegistrationController {

	@Autowired
	UserRepository userrepo;
	
	@Autowired
	MailService mailservice;
	
	
	@RequestMapping("/signup")
	public String signup() {
		return "please confirm your registration";
	}
	
	@GetMapping("/ss")
	public String sendMails(String email, String sub, String text) {
		
		//User user = userrepo.getOne(1l);
		
		try {
			mailservice.sendMail(email, sub, text);
		}catch(MailException e) {
			System.out.println("error sending mail" + e.getMessage());
		}
		
		return "thanks for register";
	}
}
