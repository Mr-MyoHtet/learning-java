package com.mybatis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.mapper.StudentMapper;
import com.mybatis.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentMapper studentMapper;

	public List<Student> getAllStudent() {
		return studentMapper.getAllStudent();

	}

	public Student findStudentById(Integer id) {
		return studentMapper.findStudentById(id);
	}

	public void insertStudent(Student student) {
		studentMapper.insertStudent(student);
	}

}
