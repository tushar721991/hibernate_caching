package com.tt.caching.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tt.caching.model.Employee;
import com.tt.caching.util.SessionFactoryProvider;

public class EmployeeClient {
	public static void main(String[] args) {

		SessionFactory factory = SessionFactoryProvider.getSessionFactory();
		Session session1 = factory.openSession();
		Employee e1 = session1.get(Employee.class, 101);
		Employee e2 = session1.get(Employee.class, 101);
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		session1.close();
		
		Session session2 = factory.openSession();
		Employee e3 = session2.get(Employee.class, 101);
		System.out.println(e3.hashCode());
		session2.close();
		
		
		factory.close();

	}
}
