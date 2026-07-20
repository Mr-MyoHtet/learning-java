package com.mybatis.services;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
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

	public List<Student> selectStudent(@Param("name") String name, @Param("email") String email,
			@Param("bio") String bio) {
		return studentMapper.selectStudent(name, email, bio);
	}

	public Student findStudentById(Integer id) {
		return studentMapper.findStudentById(id);
	}

	public void insertStudent(Student student) {
		studentMapper.insertStudent(student);
	}

	public Student findStudentWithAddress(Integer id) {
		return studentMapper.findStudentWithAddress(id);

	}

	public List<Tutors> findTutorById(Integer id) {
		return studentMapper.findTutorById(id);

	}

	public List<Course> searchCourses(Map<String, Object> map) {
		return studentMapper.searchCourses(map);
	}

	public List<Course> searchCoursesUsingChoose(Map<String, Object> map) {
		return studentMapper.searchCoursesUsingChoose(map);
	}

	public List<Course> searchCourseByWhere(Map<String, Object> map) {
		return studentMapper.searchCourseByWhere(map);
	}

	public List<Course> searchCourseByTrim(Map<String, Object> map) {
		return studentMapper.searchCourseByTrim(map);
	}

	public List<Course> searchCoursesByTutors(Map<String, Object> map) {
		return studentMapper.searchCoursesByTutors(map);
	}

	public List<Student> findAllStudents(RowBounds rowBounds) {
		return studentMapper.findAllStudents(rowBounds);
	}

}
