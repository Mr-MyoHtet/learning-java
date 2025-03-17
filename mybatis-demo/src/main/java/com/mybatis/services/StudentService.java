package com.mybatis.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.mapper.StudentMapper;
import com.mybatis.model.Course;
import com.mybatis.model.Student;
import com.mybatis.model.Tutors;

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

	public int updateStudent(Student student) {
		return studentMapper.updateStudent(student);
	}

	public Student findStudentWithAddress(Integer id) {
		return studentMapper.findStudentWithAddress(id);

	}

	public List<Tutors> findTutorById(Integer id) {
		return studentMapper.findTutorById(id);
	}
	
	public List<Course> searchCourses(Map<String,Object> map){
		return studentMapper.searchCourses(map);
	}
	
	public List<Course> searchCoursesUsingChoose(Map<String,Object> map){
		return studentMapper.searchCoursesUsingChoose(map);
	}
	
	public List<Course> searchCourseByWhere(Map<String,Object> map){
		return studentMapper.searchCourseByWhere(map);
	}
	
	public List<Course> searchCourseByTrim(Map<String,Object> map){
		return studentMapper.searchCourseByTrim(map);
	}

}
