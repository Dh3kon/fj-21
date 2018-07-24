package com.myproject.jdbc.test;

import com.myproject.jdbc.dao.EmployeeDao;
import com.myproject.jdbc.model.Employee;

public class EmployeeInsertTest {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setName("Hana Song");
		employee.setUsername("dva");
		employee.setPassword("1234");
		
		EmployeeDao dao = new EmployeeDao();
		dao.add(employee);
		
		System.out.println("Employee added with success!");
	}
}
