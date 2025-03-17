package com.mybatis;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mybatis.model.Address;
import com.mybatis.model.Course;
import com.mybatis.model.Student;
import com.mybatis.model.Tutors;
import com.mybatis.services.StudentService;

@SpringBootTest
public class StudentServiceTest {

	@Autowired
	private StudentService studentService;

//	@Test
//	void getAllStudents() {
//		
//		List<Student> result = studentService.getAllStudent();
//		System.out.println(result);
//		
//	}

//	@Test
//	void findStudentById() {
//		
//		Student student_id = studentService.findStudentById(3);
//		System.out.println(student_id);
//	}

//	@Test
//	void insertStudetn() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//
//        LocalDate dob = LocalDate.parse("19960412", formatter);
//
//		Student stu = new Student();
//		Address addr = new Address();
//		stu.setName("myo");
//		stu.setEmail("aung@gmail.com");
//		stu.setPhone("09978961902");
//        stu.setDob(dob);
//		stu.setBio("Developer");
//		addr.setAddrId(2);
//		stu.setAddress(addr);
//		studentService.insertStudent(stu);
//	}

//	@Test
//	void findStudentWithAddress() {
//		Student student_with_address = studentService.findStudentWithAddress(8);
//		System.out.println(student_with_address);
//	}

//	@Test
//	void findTutorById() {
//		List<Tutors> tutorsResult = studentService.findTutorById(2);
//		System.out.println(tutorsResult);
//
//		String name = tutorsResult.stream()
//				.filter(t -> t.getAddress() != null && t.getAddress().getCity().equals("CHICAGO")).map(Tutors::getName) 
//				.findFirst() // Get the first match (if any)
//				.orElse("No tutor found for CHICAGO"); // Default if no match is found
//
//		System.out.println(name);
//	}
//	
//	@Test
//	void searchCourses() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("tutorId", 2);
//		map.put("CourseName", "%java%");
//		map.put("description", "Java EE Course");
//		map.put("startDate", "2025-03-20");
//		List<Course> courses = studentService.searchCourses(map);
//		for (Course course : courses) {
//			System.out.println(course);
//		}
//
//	}

//	@Test
//	void searchCoursesUsingChoose() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		//map.put("searchBy", "Tutor");
//		//map.put("tutorId", 2);
//		map.put("searchBy", "CourseName");
//		map.put("CourseName", "%java%");
//		List<Course> courseResult = studentService.searchCoursesUsingChoose(map);
//		for (Course course : courseResult) {
//			System.out.println(course);
//		}
//	}
	
//	@Test
//	void searchCourseByWhere() {
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("tutorId", 2);
//		map.put("courseName", "Java SE");
//		map.put("startDate", "2025-03-20");
//		map.put("endDate","2025-05-20");
//		List<Course> courseResult = studentService.searchCourseByWhere(map);
//		for(Course course : courseResult) {
//			System.out.println(course);
//		}
//	}
//	
	@Test
	void searchCourseByTrim() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tutorId", 1);
		map.put("courseName", "Java SE");
		List<Course> courseResult = studentService.searchCourseByTrim(map);
		for(Course course : courseResult) {
			System.out.println(course);
		}
	}

}
