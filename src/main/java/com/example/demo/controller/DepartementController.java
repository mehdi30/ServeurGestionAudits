package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Departement;

@RestController
@RequestMapping("/crud_departement")
@CrossOrigin
public class DepartementController extends CrudController<Departement, Long>{

}
