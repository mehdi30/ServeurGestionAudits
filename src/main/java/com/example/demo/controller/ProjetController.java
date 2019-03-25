package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Projet;

@RestController
@RequestMapping("/crud_projet")
@CrossOrigin
public class ProjetController extends CrudController<Projet, Long>{

}
