package com.myproject.jdbc.test;

import com.myproject.jdbc.dao.EmployeeDao;
import com.myproject.jdbc.model.Employee;

public class EmployeeUpdateTest {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setId(3L);
		employee.setName("Brigitte Lindholm");
		employee.setUsername("blindholm");
		employee.setPassword("b462");
		
		EmployeeDao dao = new EmployeeDao();
		dao.update(employee);
		System.out.println("Employee updated with success!");
	}
}
