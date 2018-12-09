package com.tt.caching.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.tt.caching.model.Employee;
import com.tt.caching.util.SessionFactoryProvider;

public class QueryCache {

	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryProvider.getSessionFactory();
		
		Session session1 = factory.openSession();;
		Query<Employee> query1 = session1.createQuery("from Employee where employeeId=101", Employee.class);
		query1.setCacheable(true);
		List<Employee> employees = query1.list();
		System.out.println(employees.get(0));
		session1.close();
		
		Session session2 = factory.openSession();
		Query<Employee> query2 = session2.createQuery("from Employee where employeeId=101", Employee.class);
		query2.setCacheable(true);
		List<Employee> employees2 = query2.list();
		System.out.println(employees2.get(0));
		session2.close();
		
	}
}
