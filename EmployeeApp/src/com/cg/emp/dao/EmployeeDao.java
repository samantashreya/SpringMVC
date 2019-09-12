package com.cg.emp.dao;

import java.util.List;

import com.cg.emp.dto.Employee;
import com.cg.emp.exception.EmployeeException;

public interface EmployeeDao {
	List<Employee> getAllEmployee() throws EmployeeException;
	List<Employee> deleteEmployee(int id) throws EmployeeException;
	List<Employee> addEmployee(Employee employee) throws EmployeeException;
	Employee getEmployeeById(int id)throws EmployeeException;
	List<Employee> updateEmployee(Employee employee) throws EmployeeException;
}
