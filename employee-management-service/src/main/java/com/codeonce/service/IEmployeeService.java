package com.codeonce.service;

import java.util.List;

import com.codeonce.entity.Employee;

public interface IEmployeeService {
	public String createEmployee(Employee emp);
	public Employee getOneEmployee(Long empId);
	public void deleteEmployee(Long empId);
	public Employee updateEmployee(Long empId, Employee emp);
	public List<Employee> getAllEmployees();
	public Employee getEmpByEmail(String email);
	
}
