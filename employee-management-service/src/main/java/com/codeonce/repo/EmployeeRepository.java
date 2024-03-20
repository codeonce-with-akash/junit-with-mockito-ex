package com.codeonce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeonce.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	public Employee findByEmpEmail(String empEmail);
}
