package com.main.applications;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tables.entities.Course;
import com.tables.entities.Instructor;
import com.tables.entities.InstructorDetail;

public class CreateNewRowsInTablesDemo {
	
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
		
		// Initializing Instructor, InstructorDetail and Course Objects
		Instructor instructor = new Instructor("John", "Doe","johndoe@lorem.ipsum");
		InstructorDetail instructorDetail = new InstructorDetail("luv2code", "fashion");
		Course course1 = new Course("WICK CLASS - KILL EVERYONE WITH A PENCIL");
		Course course2 = new Course("HOW TO MASTER PAC-MAN WITH CHEATS");
		Course course3 = new Course("HOW TO MAKE DOUGH - THE ULTIMATE MASTERCLASS");
		Course course4 = new Course("yoga course with nina ^.^");
		
		instructor.setInstructorDetail(instructorDetail);
		instructor.addCourse(course1);
		instructor.addCourse(course2);
		instructor.addCourse(course3);
		instructor.addCourse(course4);

		instructorDetail.setInstructor(instructor);
		
		course1.setInstructor(instructor);
		course2.setInstructor(instructor);
		course3.setInstructor(instructor);
		course4.setInstructor(instructor);
		
		try {
			
			// !!!IMPORTANT!!!
			// If you want to save Instructor, InstructorDetail and Course Object
			// by writing this - "session.save(instructor)" IT WILL NOT WORK
			// You have to use - "session.persist(instructor)" instead
			// !!!READ BELOW FOR EXPLANATAION!!!
				// Because we used fine-grained cascading
				// (cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
				// instead of 
				// (cascade = CascadeType.ALL)
				// We need to use another method, instead of .save(), if we want to save every child item related to the parent item
				// this method is - session.persist();
			session.persist(instructor);
			// end transaction and commit changes 
			session.getTransaction().commit();
			System.out.println("Successfully saved all new entries to tables");
		}catch(Exception e) {
			System.out.println("Failed to save new Tables' Entries");
			System.out.println("Closing session");
			session.close();
			sessionFactory.close();
			e.printStackTrace();
		}
		
		
	}
	
}
