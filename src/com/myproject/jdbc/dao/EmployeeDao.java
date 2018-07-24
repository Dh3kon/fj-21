package com.myproject.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myproject.jdbc.ConnectionFactory;
import com.myproject.jdbc.model.Employee;

public class EmployeeDao {

	private Connection connection;

	public EmployeeDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void add(Employee employee) {
		String sql = "insert into employee (name, username, password) values (?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getUsername());
			stmt.setString(3, employee.getPassword());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Employee> list() {
		List<Employee> employees = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from employee");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setName(rs.getString("name"));
				employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
				employees.add(employee);
			}
			rs.close();
			stmt.close();
			return employees;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Employee employee) {
		String sql = "update employee set name = ?, username = ?, password = ? where id = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getUsername());
			stmt.setString(3, employee.getPassword());
			stmt.setLong(4, employee.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Employee employee) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from employee where id = ?");
			stmt.setLong(1, employee.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
