package com.cg.emp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.emp.dto.Employee;
import com.cg.emp.exception.EmployeeException;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceContext         //create and inject reference to entity Manager
	EntityManager entityManager; //to get the data from db
	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {
		try {
			TypedQuery<Employee> query = entityManager.createQuery("from Employee order by id",Employee.class);
			List<Employee> employees=query.getResultList();
			
			return employees;
		} catch (Exception e) {
			
			throw new EmployeeException(e.getMessage());
		}
	}
	@Override
	public List<Employee> deleteEmployee(int id) throws EmployeeException {
		try {
			Employee emp= entityManager.find(Employee.class,id);
			entityManager.remove(emp);
			
			return getAllEmployee();
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		
	}
	@Override
	public List<Employee> addEmployee(Employee employee) throws EmployeeException {
		try {
			entityManager.persist(employee);
			return getAllEmployee();
		} catch (Exception e) {
			
			throw new EmployeeException(e.getMessage());
		}
	}
	@Override
	public Employee getEmployeeById(int id) throws EmployeeException {
		
		try {
			return entityManager.find(Employee.class,id);
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
	}
	@Override
	public List<Employee> updateEmployee(Employee employee) throws EmployeeException{
		try {
			entityManager.merge(employee);
			return getAllEmployee();
		} catch (EmployeeException e) {
			throw new EmployeeException(e.getMessage());
		}
	}

}
