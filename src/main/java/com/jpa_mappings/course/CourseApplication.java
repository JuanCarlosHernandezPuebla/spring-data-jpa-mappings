package com.jpa_mappings.course;

import com.jpa_mappings.course.dao.AppDAO;
import com.jpa_mappings.course.entity.Course;
import com.jpa_mappings.course.entity.Instructor;
import com.jpa_mappings.course.entity.InstructorDetail;
import com.jpa_mappings.course.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createCourseAndReview(appDAO);

			retrieveCourseAndReviews(appDAO);

			//deleteCourseAndReview(appDAO);
		};
	}

	private void deleteCourseAndReview(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Deleting course id: " +  theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		System.out.println(tempCourse);

		System.out.println(tempCourse.getReviews());

		System.out.println("Done!");
	}

	private void createCourseAndReview(AppDAO appDAO) {

		Course tempCourse = new Course("Pacman - How to Score One Million Points");

		tempCourse.add(new Review("Great course!"));
		tempCourse.add(new Review("Cool course, job well done."));
		tempCourse.add(new Review("What a dumb course!"));

		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Juan", "Hernandez", "juanhernandez@spring.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "coding");

		Course tempCourse = new Course("Spring Boot 3, Spring 6 & Hibernate");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor.add(tempCourse);

		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting instructor detail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor detail id: " + theId);

		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructorDetail: " + tempInstructorDetail);
		System.out.println("the associated instructor: "+ tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("Juan", "Hernandez", "juanhernandez@spring.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "coding");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);

		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Updating instructor id: " + theId);
		tempInstructor.setLastName("TESTER");

		appDAO.update(tempInstructor);

		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Updating course id: " + theId);
		tempCourse.setTitle("Enjoy the Simple Things");

		appDAO.update(tempCourse);

		System.out.println("Done!");
	}

	private void deleteCourseById(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}
}
