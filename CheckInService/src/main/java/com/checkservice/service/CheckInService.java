package com.checkservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkservice.model.ModelClass;
import com.checkservice.repository.CheckInRepository;

@Service
public class CheckInService {
	
	@Autowired
	private CheckInRepository repo;
	
	public void add(String flightName) {
		ModelClass m=new ModelClass();
			List<String> list=new ArrayList();
			for(int i=1;i<60;i++) {
				if(i<20) {
					String s="A"+i;
					list.add(s);
				}				
				if(i>=20&&i<40) {
					String s1="B"+i;
					list.add(s1);
				}
				if(i>=40) {
					String s2="C"+i;
					list.add(s2);
				}
				
			}
		   	Map<String, List> map=new HashMap<>();
		   
		   	map.put(flightName, list);
		   m.setFlightName(flightName);
		   m.setSeats(map);
		repo.save(m);
		}
	public void addModel(ModelClass model) {
		repo.save(model);
	}
		
		
		
	}


