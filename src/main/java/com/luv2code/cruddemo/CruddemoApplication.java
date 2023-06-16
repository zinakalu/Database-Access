package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);
			readStudent(studentDAO);

		};
	}

	private void readStudent(StudentDAO studentDAO){
		//create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student ("Daffy", "Duck", "daffy@gmail.com");

		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		//retireve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId); //executing new code we just created

		//display the student
		System.out.println("Found the student: " + myStudent);
	}

	// private void createMultipleStudents(StudentDAO studentDAO){
		//create multiple students
	// 	System.out.println("Creating 3 student objects...");
	// 	Student tempStudent1 = new Student( "John", "Johnson", "john@gmail.com");
	// 	Student tempStudent2 = new Student( "Xavi", "Simpson", "xavi@gmail.com");
	// 	Student tempStudent3 = new Student( "Grace", "Joon", "grace@gmail.com");

		//save the student objects
	// 	System.out.println("Saving the students...");
	// 	studentDAO.save(tempStudent1);
	// 	studentDAO.save(tempStudent2);
	// 	studentDAO.save(tempStudent3);
	// }

	// private void createStudent(StudentDAO studentDAO){
		//create the student object
	// 	System.out.println("Creating new student object...");
	// 	Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		//save the student object
	// 	System.out.println("Saving the student...");
	// 	studentDAO.save(tempStudent);

		//display id of the saved student
	// 	System.out.println("Saved student. Generated id: " + tempStudent.getId());
	// } //adding to databse


}


//CommandLineRunner is from SpringBoot Framework and the body will be executed after the Spring Beans have been loaded
//The CommandLineRunner handles command-line arguments. The CommandLineRunner interface has a single method called 'run', which is intended to be overriden with custom logic to be executed when the application starts.
//the method 'commandLineRunner' creates an instance of 'CommandLineRunner'.