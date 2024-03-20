package com.codeonce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "emp_tab")
public class Employee {
	@Id
	@GeneratedValue(generator = "emp_gen")
	@SequenceGenerator(name = "emp_gen", sequenceName = "emp_seq")
	@Column(name = "emp_id_col")
	private Long empId;
	@Column(name = "emp_name_col")
	private String empName;
	@Column(name = "emp_desg_col")
	private String empDesg;
	@Column(name = "emp_dept_col")
	private String empDept;
	@Column(name = "emp_mail_col")
	private String empEmail;
	@Column(name = "emp_mob_col")
	private Long empMob;
}
