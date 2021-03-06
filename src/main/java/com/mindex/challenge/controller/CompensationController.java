package com.mindex.challenge.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;

@RestController
public class CompensationController {

	private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);
	
	@Autowired
	private CompensationService compensationService;
	
	@PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation) {
		LOG.debug("Received employee create request for [{}]", compensation);
		
		return compensationService.create(compensation);
	}
	
	@GetMapping("/compensation/{id}")
    public List<Compensation> read(@PathVariable String id) {
		LOG.debug("Received compensation get request for id [{}]", id);
		
		List<Compensation> list = compensationService.read();
		List<Compensation> result = new ArrayList<>();
		for(Compensation compensation : list) {
			if(compensation.getEmployee().getEmployeeId().equals(id))
				result.add(compensation);
		}
		
		if(result.size() == 0) {
			throw new RuntimeException("No compensation for employee id " + id);
		}
		return result;
	}
	
	
}
