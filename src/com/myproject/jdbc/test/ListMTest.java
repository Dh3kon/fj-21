package com.myproject.jdbc.test;

import java.util.List;

import com.myproject.jdbc.dao.ContactDao;
import com.myproject.jdbc.model.Contact;

public class ListMTest {

	public static void main(String[] args) {
		
		ContactDao dao = new ContactDao();
		List<Contact> contacts = dao.getListM("Burt");
		for (Contact contact : contacts) {
			System.out.println("Id: " + contact.getId());
			System.out.println("Name: " + contact.getName());
			System.out.println("Email: " + contact.getEmail());
			System.out.println("Address: " + contact.getAddress());
			System.out.println("Birth date: " + contact.getBirthDate().getTime());
		}
	}
}
