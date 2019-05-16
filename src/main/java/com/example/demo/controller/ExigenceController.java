package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Exigence;

@RestController
@RequestMapping("/crud_exigence")
//@CrossOrigin
public class ExigenceController extends CrudController<Exigence, Long> {

}
