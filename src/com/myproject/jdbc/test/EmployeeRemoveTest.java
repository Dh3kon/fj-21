package com.myproject.jdbc.test;

import com.myproject.jdbc.dao.EmployeeDao;
import com.myproject.jdbc.model.Employee;

public class EmployeeRemoveTest {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setId(4L);

		EmployeeDao dao = new EmployeeDao();
		dao.remove(employee);
		System.out.println("Employee removed with success!");
	}
}
