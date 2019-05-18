package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Notification;
import com.example.demo.respository.NotificationRepository;

@Service
@Primary
public class NotificationService implements ICrudService<Notification, Long>{

	@Autowired
	private NotificationRepository notificationRepository;
	@Override
	public List<Notification> getAll() {
		return notificationRepository.findAll();
	}
	
	public List<Notification> getByUserUsername(String username) {
		return notificationRepository.findByUserUsername(username);
	}

	public long getNotSeen(String e) {
		return notificationRepository.countNotSeen(e);
	}
	@Override
	public void add(Notification entity) {
		notificationRepository.save(entity);		
	}

	@Override
	public void update(Notification entity) {
		notificationRepository.save(entity);		
		
	}

	@Override
	public void delete(Long id) {
		
		//notificationRepository.delete(entity);		
	}

}
