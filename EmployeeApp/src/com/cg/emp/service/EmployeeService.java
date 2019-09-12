package com.cg.emp.service;

import java.util.List;

import com.cg.emp.dto.Employee;
import com.cg.emp.exception.EmployeeException;

public interface EmployeeService {
	List<Employee> getAllEmployee() throws EmployeeException;
	List<Employee> deleteEmployee(int id) throws EmployeeException;
	List<Employee> addEmployee(Employee employee) throws EmployeeException;
	Employee getEmployeeById(int id) throws EmployeeException;
	List<Employee> updateEmployee(Employee employee) throws EmployeeException;
}
