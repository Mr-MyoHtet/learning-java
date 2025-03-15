package com.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mybatis.model.Student;
import com.mybatis.model.Tutors;

@Mapper
public interface StudentMapper {
	List<Student> getAllStudent();

	Student findStudentById(Integer id);

	void insertStudent(Student student);

	int updateStudent(Student student);
	
	Student findStudentWithAddress(Integer id);
	
	List<Tutors> findTutorById(Integer id);

}
