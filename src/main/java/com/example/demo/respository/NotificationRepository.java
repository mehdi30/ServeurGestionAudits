package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Notification;
import com.example.demo.util.EtatPlanningEnum;

public interface NotificationRepository extends JpaRepository<Notification, Long>{
	
	List<Notification> findByUserId(Long id);
	List<Notification> findByUserUsername(String username);

	@Query("Select count(c) from Notification c where c.user.username=:e AND c.nSeen = false")
    long countNotSeen(@Param("e") String e); 
}
