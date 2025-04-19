package com.query.repo.criteria;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.query.entity.Course;
import com.query.repo.CourseRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class CourseRepoCriteria implements CourseRepo{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Course> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        //This is result class
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        //This is Entity class 
        //from Course c
        Root<Course> c = cq.from(Course.class);
        
        //select c
        cq.select(c);

        TypedQuery<Course> query = em.createQuery(cq);
        return query.getResultList();
    }
    
}
