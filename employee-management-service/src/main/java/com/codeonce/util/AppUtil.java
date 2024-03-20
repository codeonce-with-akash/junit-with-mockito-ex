package com.codeonce.util;

import com.codeonce.entity.Employee;

public interface AppUtil {

	public static Employee updateEmployee(Employee dbEmp, Employee reqEmp) {
		if (reqEmp.getEmpDept() != null)
			dbEmp.setEmpDept(reqEmp.getEmpDept());
		if (reqEmp.getEmpDesg() != null)
			dbEmp.setEmpDesg(reqEmp.getEmpDesg());
		if (reqEmp.getEmpEmail() != null)
			dbEmp.setEmpEmail(reqEmp.getEmpEmail());
		if (reqEmp.getEmpMob() != null)
			dbEmp.setEmpMob(reqEmp.getEmpMob());
		if (reqEmp.getEmpName() != null)
			dbEmp.setEmpName(reqEmp.getEmpName());
		return dbEmp;
	}
}
