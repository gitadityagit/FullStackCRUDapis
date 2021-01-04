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
		mv.addObject("emp", emp);
		return mv;
	}
	
	//update record
	@RequestMapping("/updateRecord")
	public ModelAndView updataRecord(Employee emp) {
		ModelAndView mv=new ModelAndView("form.jsp");
		repo.save(emp);
		return mv;
	}
	
	//delete
	@RequestMapping("/deleteRecord")
	public ModelAndView deleteRecord(int id) {
		ModelAndView mv=new ModelAndView("form.jsp");
		repo.deleteById(id);
		return mv;
	}
}


