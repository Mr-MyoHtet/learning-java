package com.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.mybatis.model.Course;
import com.mybatis.model.Student;
import com.mybatis.model.Tutors;

@Mapper
public interface StudentMapper {
	List<Student> getAllStudent();

	Student findStudentById(Integer id);

	void insertStudent(Student student);
	
	//one-to-one
	Student findStudentWithAddress(Integer id);
	
	//one-to-many
	List<Tutors> findTutorById(Integer id);
	
	//Dynnamic query if condition
	List<Course>  searchCourses(Map<String,Object> map);
	
	//Dynamic query using choose it like switch in java
	List<Course> searchCoursesUsingChoose(Map<String,Object> map);
	
	
	//where condition
	List<Course> searchCourseByWhere(Map<String,Object> map);
	
	//The trim condition
	List<Course> searchCourseByTrim(Map<String,Object> map);
	
	//forEach Search Course By Tutors
	List<Course> searchCoursesByTutors(Map<String,Object> map);
	
	//RowBounds for pagination
	List<Student> findAllStudents(RowBounds rowBounds);
	
	
}
