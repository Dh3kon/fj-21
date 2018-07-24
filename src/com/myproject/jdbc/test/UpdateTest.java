package com.myproject.jdbc.test;

import java.util.Calendar;
import java.util.Date;

import com.myproject.jdbc.dao.ContactDao;
import com.myproject.jdbc.model.Contact;

public class UpdateTest {

	public static void main(String[] args) {
		ContactDao dao = new ContactDao();
		Contact contact = new Contact();
		contact.setId(1001L);
		contact.setName("Angela Ziggler");
		contact.setAddress("255 Kings Row Avenue");
		contact.setEmail("mercy@overwatch.com");
		Calendar date_b = Calendar.getInstance();
		contact.setBirthDate(date_b);
		
		dao.update(contact);
		System.out.println("Update with success");
	}
}
