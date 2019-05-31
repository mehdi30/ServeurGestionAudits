package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
@Primary
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	/*@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}*/
	
	public void sendMail(String email, String subj, String text) throws MailException {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject(subj);
		mail.setText(text);
		javaMailSender.send(mail);
	}


}
