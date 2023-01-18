package com.tables.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	// Fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructorId;
	
	// Constructors
	
	public Course() {}

	public Course(String title) {
		this.title = title;
	}

	public Course(String title, Instructor instructorId) {
		this.title = title;
		this.instructorId = instructorId;
	}

	// toString

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructorId + "]";
	}

	
	// Getters and Setters
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructorId;
	}

	public void setInstructor(Instructor instructorId) {
		this.instructorId = instructorId;
	}

	
	
	
}
