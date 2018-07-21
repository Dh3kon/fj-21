package com.myproject.jdbc.test;

import java.text.SimpleDateFormat;
import java.util.List;

import com.myproject.jdbc.dao.ContactDao;
import com.myproject.jdbc.model.Contact;

public class ListTest {

	public static void main(String[] args) {
		ContactDao dao = new ContactDao();
		List<Contact> contacts = dao.getList();
		for (Contact contact : contacts) {
			System.out.println("Name: " + contact.getName());
			System.out.println("Email: " + contact.getEmail());
			System.out.println("Address: " + contact.getAddress());
			System.out.println("Birth date: " + new SimpleDateFormat("dd/MM/yyyy").format(contact.getBirthDate().getTime()) + "\n");
		}
	}
}
