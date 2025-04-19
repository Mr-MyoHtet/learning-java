package com.query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.query.repo.criteria.CourseRepoCriteria;
import com.query.repo.jpql.CourseRepoJpql;

@SpringBootTest
public class CourseRepoTest {

  @Autowired
  private CourseRepoJpql courseRepoJpql;

   @Autowired
   private CourseRepoCriteria courseRepoCriteria;
   
   @Test
   void findAllTest() {
    //for Jpql
    var result1 = courseRepoJpql.findAll();
    System.out.println(result1);
    
    //Criteria
     var result2 = courseRepoCriteria.findAll();
     System.out.println(result2);
   }
}
