package com.codeonce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeonce.entity.Employee;
import com.codeonce.exception.EmployeeNotFoundException;
import com.codeonce.repo.EmployeeRepository;
import com.codeonce.service.IEmployeeService;
import com.codeonce.util.AppUtil;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public String createEmployee(Employee emp) {
		Employee employee = empRepo.save(emp);
		return new StringBuilder("EMPLOYEE ").append(employee.getEmpId()).append(" SAVED SUCCESSFULLY!").toString();
	}

	@Override
	public Employee getOneEmployee(Long empId) {
		return empRepo.findById(empId)
				.orElseThrow(() -> new EmployeeNotFoundException("EMPLOYEE '" + empId + "' NOT EXIST!"));
	}

	@Override
	public void deleteEmployee(Long empId) {
		Employee oneEmployee = getOneEmployee(empId);
		empRepo.delete(oneEmployee);
	}

	@Override
	@Transactional
	public Employee updateEmployee(Long empId, Employee emp) {
		Employee employee = getOneEmployee(empId);
		Employee updatedEmployee = AppUtil.updateEmployee(employee, emp);
		return empRepo.save(updatedEmployee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Employee getEmpByEmail(String email) {
		Employee employee = empRepo.findByEmpEmail(email);
		if (employee == null)
			throw new EmployeeNotFoundException(email + " NOT EXIST!");
		return employee;
	}
}
