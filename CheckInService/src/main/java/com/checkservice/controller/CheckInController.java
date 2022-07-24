package com.checkservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.checkservice.model.ModelClass;
import com.checkservice.service.CheckInService;

@RestController
public class CheckInController {
	
	@Autowired
	private CheckInService service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add/{name}")
	public ResponseEntity<?> add(@PathVariable String name){
		
		service.add(name);
		return ResponseEntity.ok("added");
		
	}
	@PostMapping("/addmodel")
	public String addModel(@RequestBody ModelClass model) {
		service.addModel(model);
		return "Added";
	}

}
