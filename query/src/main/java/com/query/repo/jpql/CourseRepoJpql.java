package com.query.repo.jpql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.query.entity.Course;
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
        var jpql = "select c from Course c";
        var query = em.createQuery(jpql,Course.class);
        return query.getResultList();
    }

}
