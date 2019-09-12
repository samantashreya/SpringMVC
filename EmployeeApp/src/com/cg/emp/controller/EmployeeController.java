package com.cg.emp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.emp.dto.Employee;
import com.cg.emp.exception.EmployeeException;
import com.cg.emp.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/greet")
	public String sayHello() {

		return "greet";
	}

	@RequestMapping("/")
	public ModelAndView showIndex() {
		try {

			List<Employee> employees = employeeService.getAllEmployee();

			ModelAndView mv = new ModelAndView("index");
			mv.addObject("employees", employees);
			return mv;
		} catch (EmployeeException e) {
			e.printStackTrace(); // to check exception
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error", e);
			return mv;
		}
	}

	@RequestMapping("/delete")
	public ModelAndView deleteEmployee(@RequestParam int id) {
		// to extract the parameter @RequestParam used
		// if parameter name is different @RequestParam("empId")int id
		try {
			List<Employee> employees = employeeService.deleteEmployee(id);
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("employees", employees);
			return mv;
		} catch (EmployeeException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error", e);
			return mv;

		}

	}

	@RequestMapping("/addEmployee")
	public String showAddForm(Model model) {
		model.addAttribute("employee", new Employee());// new empty employee object

		return "add";// ui =add.jsp

	}

	@RequestMapping(value = "/add",method = RequestMethod.POST)
	//binding result contains the error information
	public ModelAndView addEmployee(@Valid @ModelAttribute Employee employee,BindingResult result) {
		if(result.hasErrors()) {
			/*
			 * ModelAndView mv=new ModelAndView(index); mv.addObject("employee",employee);
			 * return mv;
			 */
			
			return new ModelAndView("add","employee",employee);
		}
		
		try {
			List<Employee> employees = employeeService.addEmployee(employee);
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("employees", employees);
			return mv;
		} catch (EmployeeException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error", e);
			return mv;
		}
		
	}
	@RequestMapping("/update")
	public String showUpdate(@RequestParam int id,Model model) {
		try {
			Employee employee=employeeService.getEmployeeById(id);
			model.addAttribute("employee", employee); //to populate the data in the form
			return "update";
		} catch (EmployeeException e) {
			model.addAttribute("error",e);
			return "error";
		}
	}
	@RequestMapping(value="/updateEmployee",method = RequestMethod.POST)
	public ModelAndView updateEmployee(@Valid @ModelAttribute Employee employee,BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("update","employee",employee);
		}
		try {
			List<Employee> employees=employeeService.updateEmployee(employee);
			return new ModelAndView("index","employees",employees);
		} catch (EmployeeException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error", e);
			return mv;
		}
	}
}
