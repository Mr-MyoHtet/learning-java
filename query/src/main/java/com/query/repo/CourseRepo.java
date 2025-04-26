package com.query.repo;

import java.util.List;

import com.query.entity.Course;
import com.query.entity.dto.CourseDto;

public interface CourseRepo {

   List<Course> findAll();

   List<String> findAllNames();

   Long CountAll();

   Double AverageHours();

   Long findSumFees();

   List<CourseDto> findCourseDto();

}
