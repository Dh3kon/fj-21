package com.myproject.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.myproject.jdbc.exception.DaoException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/fj21?useSSL=false", "root", "1234");
		} catch (SQLException e) {
			throw new DaoException();
		}
	}
}
