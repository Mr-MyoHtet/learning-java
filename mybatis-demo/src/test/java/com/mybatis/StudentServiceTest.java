package com.mybatis;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mybatis.model.Student;
import com.mybatis.services.StudentService;

@SpringBootTest
public class StudentServiceTest {

	
	@Autowired
	private StudentService studentService;

	@Test
	void getAllStudents() {
		
		List<Student> result = studentService.getAllStudent();
		System.out.println(result);
		
	}
	
	@Test
	void findStudentById() {
		
		Student student_id = studentService.findStudentById(2);
		System.out.println(student_id);
	}
	
	@Test
	void insertStudetn() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        LocalDate dob = LocalDate.parse("19960412", formatter);

		Student stu = new Student();
		stu.setName("aung");
		stu.setEmail("aung@gmail.com");
		stu.setPhone("09978961902");
        stu.setDob(dob);
		stu.setBio("tester");
		studentService.insertStudent(stu);
	}
}
