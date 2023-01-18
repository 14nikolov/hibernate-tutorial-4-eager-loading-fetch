package com.main.applications;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tables.entities.Course;
import com.tables.entities.Instructor;
import com.tables.entities.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).
				addAnnotatedClass(Course.class).
				buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		try {
			
			// Retrieve Instructor Courses from Database Table
			int theId = 14;
			Instructor instructor = session.get(Instructor.class, theId);
			
			List<Course> courses = instructor.getCourses();
			
			// print the Instructor toString method
			System.out.println("\n\n\nINSTRUCTOR:\n" + instructor.toString() + "\n\n\n");
			// print total number of Instructor Courses
			System.out.println("\n\n\nINSTRUCTOR NUMBER OF COURSES: " + instructor.getCourses().size());
			// print a list of all of the courses of this Instructor
				// we will print the courses' toString methods
			System.out.println("\n\n\nINSTRUCTOR COURSES: " + instructor.getCourses());
			
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("\n\n\nTransaction Failed");
			System.out.println("Closing Session and SessionFactory\n\n\n");
			session.close();
			sessionFactory.close();
			e.printStackTrace();
		}
	}
	
}
