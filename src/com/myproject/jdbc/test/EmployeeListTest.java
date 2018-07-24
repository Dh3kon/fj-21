package com.myproject.jdbc.test;

import java.util.List;

import com.myproject.jdbc.dao.EmployeeDao;
import com.myproject.jdbc.model.Employee;

public class EmployeeListTest {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		List<Employee> employees = dao.list();
		for (Employee employee : employees) {
			System.out.println("Id: " + employee.getId());
			System.out.println("Name: " + employee.getName());
			System.out.println("Username: " + employee.getUsername());
			System.out.println("Password: " + employee.getPassword());
		}
	}
}
