package com.query;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.query.entity.Course;
import com.query.repo.jpql.CourseRepoJpql;

@SpringBootTest
public class CourseRepoTest {
	
	@Autowired
    private CourseRepoJpql courseRepoJpql;

    @Test
    void testFindAll() {
        List<Course> courses = courseRepoJpql.findALL();
       courses.forEach(System.out::println);
        
    }
}
