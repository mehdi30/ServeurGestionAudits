package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Source;

@RestController
@RequestMapping("/crud_source")
@CrossOrigin
public class SourceController extends CrudController<Source, Long>{

}
