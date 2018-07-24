package com.myproject.jdbc.test;

import com.myproject.jdbc.dao.ContactDao;
import com.myproject.jdbc.model.Contact;

public class DeleteTest {

	public static void main(String[] args) {
		Contact contact = new Contact();
		contact.setId(1002L);

		ContactDao dao = new ContactDao();
		dao.remove(contact);
		System.out.println("Contact deleted with success!");
	}
}
