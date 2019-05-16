package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Audit;

@RestController
@RequestMapping("/crud_audit")
//@CrossOrigin
public class AuditController extends CrudController<Audit, Long>{

}
