package com.cg.cust.controller;

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

import com.cg.cust.dto.Customer;
import com.cg.cust.exception.CustomerException;
import com.cg.cust.service.CustomeService;

@Controller
//@RequestMapping("/greet")
public class CustomerController {
	@Autowired
	private CustomeService customerService;

	@RequestMapping("/hello")
	public String sayHello() {
		return "greet";
	}

	@RequestMapping("/")
	public ModelAndView showAllCustomers() {
		try {
			List<Customer> customers = customerService.getAllCustomers();
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("customers", customers);
			return mv;
		} catch (CustomerException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error", e);
			return mv;
		}

	}

	@RequestMapping("/delete")
	public ModelAndView deleteCustomer(@RequestParam int id) {
		try {
			List<Customer> customers = customerService.deleteCustomer(id);
			ModelAndView mv = new ModelAndView();
			mv.addObject("customers", customers);
			return mv;
		} catch (CustomerException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error", e);
			return mv;
		}

	}

	@RequestMapping("/addCustomer")
	public String showAddForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "add";

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addCustomer(@Valid @ModelAttribute Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("add", "customer", customer);
		}
		try {
			List<Customer> customers = customerService.addCustomer(customer);
			return new ModelAndView("index", "customers", customers);
		} catch (CustomerException e) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("error", e);
			return mv;
		}
	}
	@RequestMapping(value = "/update")
    public String showUpdateForm(@RequestParam int id, Model model) {
        try {
            Customer customer = customerService.getCustomerById(id);
            model.addAttribute("customer", customer);
            return "update";
        } catch (CustomerException e) {
            model.addAttribute("error", e);
        }

 

        return "error";
    }
    
    @RequestMapping(value="/updateCustomer",method=RequestMethod.POST)
    public ModelAndView updateCustomer(@Valid @ModelAttribute Customer customer,BindingResult result) {
        
        if (result.hasErrors()) {
            /**
             *
             * ModelAndView mv = new ModelAndView("index");
             * mv.addObject("employee",employee); return mv;
             *
             * above code can be simplified as:-
             */
            return new ModelAndView("update", "customer", customer);
        }

 

        try {
            List<Customer> customers = customerService.updateCustomer(customer);
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("customers", customers);
            return modelAndView;
        } catch (CustomerException e) {
            e.printStackTrace();
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("error", e);
            return modelAndView;
        }
    }

	

	
}
