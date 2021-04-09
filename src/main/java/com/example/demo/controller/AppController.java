package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.repository.Repo;
import java.util.*;

@RestController
public class AppController {
	
	@Autowired
	Repo repo;
	
	//all forms
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv=new ModelAndView("form.jsp");
		
		return mv;
	}
	
	//get all records
	@RequestMapping("/getAllRecords")
	public List<Employee> getAllRecords(){
		List<Employee> list=repo.findAll();
		return list;
	}
	
	//create
	@RequestMapping("/addRecord")
	public ModelAndView addRecord(Employee emp) {
		ModelAndView mv=new ModelAndView("form.jsp");
		repo.save(emp);
		return mv;
	}
	
	//retrieve
	@RequestMapping("/getRecord")
	public ModelAndView getRecord(int id) {
		ModelAndView mv=new ModelAndView("record.jsp");
		Employee emp=repo.findById(id).orElse(null);
		
		if(emp==null) {
			ModelAndView mv1=new ModelAndView("blank.jsp");
			mv1.addObject("id", id);
			return mv1;
		}
		mv.addObject("emp", emp);
		return mv;
	}
	
	//update record
	@RequestMapping("/updateRecord")
	public ModelAndView updataRecord(Employee emp) {
		System.out.println(emp.getId()+" "+emp.getName());
		if(!repo.existsById(emp.getId() ) ) {
			ModelAndView mv1=new ModelAndView("blank.jsp");
			mv1.addObject("id", emp.getId());
			return mv1;
		}
		
		ModelAndView mv=new ModelAndView("form.jsp");
		repo.save(emp);
		return mv;
	}
	
	//delete
	@RequestMapping("/deleteRecord")
	public ModelAndView deleteRecord(int id) {
		ModelAndView mv=new ModelAndView("delete.jsp");
		if(repo.count()==0) {
			ModelAndView mv1=new ModelAndView("blank.jsp");
			mv1.addObject("id", id);
			return mv1;
		}
		mv.addObject("id",id);
		repo.deleteById(id);
		return mv;
	}
}


