package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Produit;

public interface ICrudService<T, ID> {

	List<T> getAll();
	
	void add(T entity);
	
	void update(T entity);
	
	void delete(ID id);
}
