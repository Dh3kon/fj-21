package com.myproject.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.myproject.jdbc.ConnectionFactory;
import com.myproject.jdbc.exception.DaoException;
import com.myproject.jdbc.model.Contact;

public class ContactDao {

	private Connection connection;

	public ContactDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void add(Contact contact) {
		String sql = "insert into contact (name, email, address, birthDate) values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, new Date(contact.getBirthDate().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contact> getList() {
		try {
			List<Contact> contacts = new ArrayList<>();
			PreparedStatement stmt = connection.prepareStatement("select * from contact");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getLong("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				Calendar date_b = Calendar.getInstance();
				date_b.setTime(rs.getDate("birthDate"));
				contact.setBirthDate(date_b);
				contacts.add(contact);
			}
			rs.close();
			stmt.close();
			return contacts;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	public void update(Contact contact) {
		String sql = "update contact set name = ?, email = ?, address = ?, birthDate =? where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, new Date(contact.getBirthDate().getTimeInMillis()));
			stmt.setLong(5, contact.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Contact contact) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contact where id = ?");
			stmt.setLong(1, contact.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DaoException();
		}
	}

	public List<Contact> getListM(String name) {
		try {
			List<Contact> contacts = new ArrayList<>();
			PreparedStatement stmt = connection
					.prepareStatement("select * from contact where name like '%" + name + "%'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getLong("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				Calendar date_b = Calendar.getInstance();
				date_b.setTime(rs.getDate("birthDate"));
				contact.setBirthDate(date_b);
				contacts.add(contact);
			}
			rs.close();
			stmt.close();
			return contacts;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contact> getListP(int id) {
		try {
			List<Contact> contacts = new ArrayList<>();
			PreparedStatement stmt = connection.prepareStatement("select * from contact where id = " + id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getLong("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				Calendar date_b = Calendar.getInstance();
				date_b.setTime(rs.getDate("birthDate"));
				contact.setBirthDate(date_b);
				contacts.add(contact);
			}
			rs.close();
			stmt.close();
			return contacts;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
