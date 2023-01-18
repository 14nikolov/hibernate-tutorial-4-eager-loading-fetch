# hibernate-tutorial-4-eager-loading(fetch)

When you download this project, make sure to also download this project:
	- hibernate-tutorial-4-lazy-loading(fetch)
	
In one project we explain EAGER Loading
In the other one we explain LAZY Loading

---I. Project Purpose ----------------------------------------------------------------------------------- 
	
	- The project is based on Section 25 from the Udemy course
	 Spring & Hibernate for Beginners (includes Spring Boot) by Chad Darby
	 
	- In this section we learn about:
		- Eager vs Lazy Loading 
				examples: @OneToMany(fetch=FetchType.LAZY)
					  @OneToMany(fetch=FetchType.EAGER)	
					  Does not have to be @OneToMany, you can also use @OneToOne, @ManyToOne
		- Hibernate Fetching Strategies (HQL Query that retrieves objects from the Table, even after session is closed)
	
	- Section 25 as of the time of making this project is:
    	Section 25: Hibernate Advanced Mappings - Eager vs Lazy Loading
	
---II. Project requires:---------------------------------------------------------------------------------------
	
	- Used OS - Windows 11 Pro 22H2 
	- Eclipse IDE (Used Version: 2022-09 (4.25.0) Build id: 20220908-1902)
	- Java 8 or 11 (Used Version: 11)
	- MySQL Server (Used Version: 8.0.31 MySQL Community Server - GPL)
	- MySQL Workbench (Used Version: 8.0.31 build 2235049 CE (64 bits) Community)
	- MySQL Connector/J (Used Version: Platform Independent mysql-connector-j-8.0.31)
	- Hibernate ORM 5.6.x. (Used Version: 5.6.5)
	- hibernate.cfg.xml starter file 

	
	
