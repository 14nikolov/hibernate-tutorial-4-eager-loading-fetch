package com.main.applications;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tables.entities.Course;
import com.tables.entities.Instructor;
import com.tables.entities.InstructorDetail;

public class DeleteCourseDemo {
	
	public static void main(String[] args) {
		
		// build session factory and configure it
				SessionFactory sessionFactory = new Configuration().
						configure("hibernate.cfg.xml").
						addAnnotatedClass(Instructor.class).
						addAnnotatedClass(InstructorDetail.class).
						addAnnotatedClass(Course.class).
						buildSessionFactory();
				
		// create a new session
		Session session = sessionFactory.getCurrentSession();
				
		// start a new transaction
		session.beginTransaction();
		
		try {
			int courseId = 15;
			Course course = session.get(Course.class, courseId);
			session.delete(course);
			// end transaction and commit changes 
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Failed to delete Instructor Table Row/Object");
			System.out.println("Closing session and Closing SessionFactory");
			session.close();
			sessionFactory.close();
			e.printStackTrace();
		}
	}
}
