package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EnJeux;

@RestController
@RequestMapping("/crud_enjeux")
@CrossOrigin
public class EnJeuxController extends CrudController<EnJeux, Long>{

}
