package com.myproject.jdbc.dao;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import com.myproject.jdbc.model.Contact;

public class ListPTest {

	public static void main(String[] args) {

		Random random = new Random();

		ContactDao dao = new ContactDao();
		List<Contact> contacts = dao.getListP(random.nextInt(1000));
		for (Contact contact : contacts) {
			System.out.println("Id: " + contact.getId());
			System.out.println("Name: " + contact.getName());
			System.out.println("Email: " + contact.getEmail());
			System.out.println("Address: " + contact.getAddress());
			System.out.println("Birth date: "
					+ new SimpleDateFormat("dd/MM/yyyy").format(contact.getBirthDate().getTime()) + "\n");
		}
	}
}
