package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Ecart;

@RestController
@RequestMapping("/crud_ecart")
@CrossOrigin
public class EcartController extends CrudController<Ecart, Long>{

}
