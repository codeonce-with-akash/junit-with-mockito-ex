package com.codeonce.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeonce.entity.Employee;
import com.codeonce.service.IEmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeRestController {
	@Autowired
	private IEmployeeService empService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createEmployee(@RequestBody Employee emp){
		return new ResponseEntity<>(empService.createEmployee(emp), HttpStatus.CREATED);
	}
	
	@GetMapping("/one/{empId}")
	public ResponseEntity<Employee> getOneEmpoyee(@PathVariable Long empId){
		return new ResponseEntity<>(empService.getOneEmployee(empId), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmpoyee(@PathVariable Long empId){
		empService.deleteEmployee(empId);
		return new ResponseEntity<>("EMPLOYEE '"+empId+"' DELETED SUCCESSFULLY!", HttpStatus.OK);
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<Employee> updateEmpoyee(@PathVariable Long empId, @RequestBody Employee employee){
		return new ResponseEntity<>(empService.updateEmployee(empId, employee), HttpStatus.OK);
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<List<Employee>> allEmpoyees(){
		return new ResponseEntity<>(empService.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/one")
	public ResponseEntity<Employee> allEmpoyees(@RequestParam String email){
		return new ResponseEntity<>(empService.getEmpByEmail(email), HttpStatus.OK);
	}
}
