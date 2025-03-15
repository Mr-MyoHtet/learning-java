package com.mybatis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mybatis.model.Address;
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

	@Test
	void findTutorById() {
		List<Tutors> tutorsResult = studentService.findTutorById(2);
		System.out.println(tutorsResult);

		String name = tutorsResult.stream()
				.filter(t -> t.getAddress() != null && t.getAddress().getCity().equals("CHICAGO")).map(Tutors::getName) 
				.findFirst() // Get the first match (if any)
				.orElse("No tutor found for CHICAGO"); // Default if no match is found

// Print the name of the tutor found
		System.out.println(name);
	}
}
