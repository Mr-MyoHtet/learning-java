package com.query.repo;

import java.util.List;

import com.query.entity.Course;

public interface CourseRepo {

   List<Course> findAll();

}
