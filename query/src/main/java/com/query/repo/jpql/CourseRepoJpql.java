package com.query.repo.jpql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.query.entity.Course;
import com.query.entity.dto.CourseDto;
import com.query.repo.CourseRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CourseRepoJpql  implements CourseRepo{

  @PersistenceContext
  private EntityManager em;

    @Override
    public List<Course> findAll() { 
        //Course is Entity ,is not table name
        // var jpql = "select c from Course c";
        //var query = em.createQuery(jpql,Course.class);
        var query = em.createNamedQuery("Course.All",Course.class);
        return query.getResultList();
    }

    @Override
    //String.class ကလိုချင်တဲ. result type List<String> findAllNames();
    public List<String> findAllNames() {
      var query = em.createNamedQuery("Course.getAllNames",String.class);
     return query.getResultList();
    }

    @Override
    public Long CountAll() {
    var query = em.createNamedQuery("Course.CountAll",Long.class);
    return query.getSingleResult();
    }

    @Override
    public Double AverageHours() {
      var query = em.createNamedQuery("Course.findAverageHours",Double.class);
      return query.getSingleResult();
    }

    @Override
    public Long findSumFees() {
      var query = em.createNamedQuery("Course.findSumfees",Long.class);
      return query.getSingleResult();
    }

    @Override
    public List<CourseDto> findCourseDto() {
     var query = em.createNamedQuery("Course.findCourseDto",CourseDto.class);
     return query.getResultList();
    }

}
