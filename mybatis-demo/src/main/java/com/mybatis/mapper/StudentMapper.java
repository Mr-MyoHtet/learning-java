package com.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mybatis.model.Student;

@Mapper
public interface StudentMapper {
	List<Student> getAllStudent();
	
	Student findStudentById(Integer id);
	
	void insertStudent (Student student);
	
}
