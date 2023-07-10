package com.gl.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.entity.Employee;
import com.gl.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	private EmployeeService empService;
	
	public EmployeeController(EmployeeService theBookService) {
		empService = theBookService;
	}
	
	// add mapping for "/list"
	@GetMapping("/empList")
	public String listEmployee(Model theModel) {
		
		// get Employee from database
		List<Employee> employeeList = empService.findAll();
		
		// add to the spring model
		theModel.addAttribute("employeeList", employeeList);
		
		return "employee/list-emp";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Employee employee = new Employee();
		String heading = "Create New Employee";
		theModel.addAttribute("heading", heading);
		theModel.addAttribute("employee", employee);
		
		return "employee/emp-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("empId") int theId,
									Model theModel) {
		
		Employee theEmp = empService.findById(theId);
		
		String heading = "Update Employee";
		theModel.addAttribute("heading", heading);
		theModel.addAttribute("employee", theEmp);
		
		// send over to our form
		return "employee/emp-form";			
	}
	
	
	@PostMapping("/save")
	public String saveEmp(@ModelAttribute("employee") Employee theEmp) {
		
		empService.save(theEmp);
		
		return "redirect:/emp/empList";
	}
	
	
	@PostMapping("/delete")
	public String delete(@RequestParam("empId") int theId) {
		
		// delete the employee
		empService.deleteById(theId);
		
		return "redirect:/emp/empList";
	}
}


















