package com.myproject.jdbc.test;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.myproject.jdbc.dao.ContactDao;
import com.myproject.jdbc.model.Contact;

public class InsertTest {

	public static void main(String[] args) {
		Contact contact = new Contact();
		contact.setName("Mercy");
		contact.setEmail("mercy@overwatch.com");
		contact.setAddress("Recovery Park");
		contact.setBirthDate(Calendar.getInstance());

		ContactDao dao = new ContactDao();
		dao.add(contact);
		System.out.println("Contact added to database!");
	}

}
