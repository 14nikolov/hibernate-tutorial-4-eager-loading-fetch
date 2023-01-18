package com.tables.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Fetch Type of this class' variable "courses"
// is set to "Eager"
// @OneToMany(fetch=FetchType.EAGER)
// find the variable "courses" below and look at it
@Entity
@Table(name="instructor")
public class Instructor {
	
	// Fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetailId;
	
	// setting Fetch Type to EAGER (eager loading)
	// this fetch type makes it so the instructor is loaded
	// along with all of his courses
	@OneToMany(fetch=FetchType.EAGER, mappedBy="instructorId", 
			cascade = {CascadeType.DETACH,CascadeType.MERGE,
					CascadeType.PERSIST,CascadeType.REFRESH,})
	private List<Course> courses;

	// Constructors
	
	public Instructor() {}
	
	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Instructor(int id, String firstName, String lastName, String email, InstructorDetail instructorDetailId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.instructorDetailId = instructorDetailId;
	}

	public Instructor(int id, String firstName, String lastName, String email, List<Course> courses) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.courses = courses;
	}

	public Instructor(int id, String firstName, String lastName, String email, InstructorDetail instructorDetailId,
			List<Course> courses) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.instructorDetailId = instructorDetailId;
		this.courses = courses;
	}
	
	// convenience method (that is an actual programming lingo/term/jargon)
	// A convenience method, in any language which has a concept of methods,
	// is just that. A method that makes things more convenient. 
	// This usually means taking something that is complex or verbose, 
	// and making it more accessible.
		// In this case this method will make it easier for us to
		// add a new course to the instructor
		// and also link/map the new course and the instructor to each other
	public void addCourse(Course tempCourse) {
		
		// If "List<Course> courses" is not initialized
		// then we initialize it
		if(courses==null) {
			courses = new ArrayList<>();
		}
		
		// add course to our list "List<Course> courses"
		// set the course's Instructor object reference to
		// the current Instructor object
		courses.add(tempCourse);
		tempCourse.setInstructor(this);
		
	}
	
	// toString

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}

	// Getters and Setters

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetailId;
	}

	public void setInstructorDetail(InstructorDetail instructorDetailId) {
		this.instructorDetailId = instructorDetailId;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	

}
