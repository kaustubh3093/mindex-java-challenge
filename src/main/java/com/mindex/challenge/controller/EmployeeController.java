package com.mindex.challenge.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;

@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        LOG.debug("Received employee create request for [{}]", employee);

        return employeeService.create(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return employeeService.read(id);
    }

    @GetMapping("/reportingStructure/{id}")
    public ReportingStructure getReportingStructure(@PathVariable String id) {
    	LOG.debug("Get Reporting structure for employee with id [{}]", id);
    	
    	Employee employee = employeeService.read(id);
    	List<Employee> listOfEmployee = employee.getDirectReports();
    	Set<String> set = new HashSet<>();
    	int totalReporting = listOfEmployee.size();
    	while(listOfEmployee.size() != 0) {
    		List<Employee> newList = new ArrayList<>();
    		for(Employee innerEmp : listOfEmployee) {
    			set.add(innerEmp.getEmployeeId());
    			if(employeeService.read(innerEmp.getEmployeeId()).getDirectReports() != null) {
    				newList.addAll(employeeService.read(innerEmp.getEmployeeId()).getDirectReports());
    			}
    		}
    		listOfEmployee = new ArrayList<>(newList);
    	}
    	totalReporting = set.size();
    	return new ReportingStructure(employee, totalReporting);
    }
    
    @PutMapping("/employee/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        LOG.debug("Received employee create request for id [{}] and employee [{}]", id, employee);

        employee.setEmployeeId(id);
        return employeeService.update(employee);
    }
}
