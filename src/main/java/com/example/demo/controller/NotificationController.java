package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Notification;
import com.example.demo.service.NotificationService;
import com.example.demo.util.EtatPlanningEnum;

@RestController
@RequestMapping("/crud_notification")
public class NotificationController extends CrudController<Notification, Long>{
	
	@Autowired
	NotificationService notificationService;
	
	@Autowired
	NotificationController notificationController;
	
	@Autowired
	UserController userController;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<Notification> getByUserUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = ((UserDetails)principal).getUsername();
			
			return notificationService.getByUserUsername(username);

			

	}
	
	@RequestMapping(value = "/seen", method = RequestMethod.GET)
	public long getnotSeen() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = ((UserDetails)principal).getUsername();
			
			return notificationService.getNotSeen(username);

	}
	
     @RequestMapping(value = "/setSeen", method = RequestMethod.PUT)
	public void updatePlanningDepartement() {

    	 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = ((UserDetails)principal).getUsername();
			
    	 List<Notification> notifs = notificationService.getByUserUsername(username);
			for(Notification n : notifs)
			{
				if(n.isnSeen() == false) {
					n.setnSeen(true);
					notificationService.update(n);
				}
			}
	}

}
