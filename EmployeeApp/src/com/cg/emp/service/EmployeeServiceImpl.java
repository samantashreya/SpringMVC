package com.cg.emp.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.emp.dao.EmployeeDao;
import com.cg.emp.dto.Employee;
import com.cg.emp.exception.EmployeeException;
@Service
@Transactional        //to take care of transaction--all the methods inside this class is transactional,works at method level as well as class level 
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {
		
		return employeeDao.getAllEmployee();
	}
	@Override
	public List<Employee> deleteEmployee(int id) throws EmployeeException {
	
		return employeeDao.deleteEmployee(id);
	}
	@Override
	public List<Employee> addEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDao.addEmployee(employee);
	}
	
	@Override
	public List<Employee> updateEmployee(Employee employee) throws EmployeeException {
		
		return employeeDao.updateEmployee(employee);
	}
	@Override
    public Employee getEmployeeById(int id) throws EmployeeException {
        return employeeDao.getEmployeeById(id);
    }

}
