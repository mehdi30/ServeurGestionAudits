package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.entity.ActionProjet;
import com.example.demo.util.StatusEnum;

public interface IActionProjet {
	
	List<ActionProjet> getByStatus(StatusEnum status);
	void updateActionProjet(Long id, ActionProjet c) ;
}
