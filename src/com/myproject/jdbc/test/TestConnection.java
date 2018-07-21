package com.myproject.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.myproject.jdbc.ConnectionFactory;

public class TestConnection {
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Connection open!");
		connection.close();
	}
}
