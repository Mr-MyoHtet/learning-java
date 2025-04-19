package com.query.repo.criteria;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.query.entity.Course;
import com.query.entity.dto.CourseDto;
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

    @Override
    public List<String> findAllNames() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        //လိုချင်တဲ. result type
        CriteriaQuery<String> cq = cb.createQuery(String.class);

        Root<Course> c = cq.from(Course.class);
        cq.select(c.get("name"));

        TypedQuery<String> query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Long CountAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);

        Root<Course> c = cq.from(Course.class);
        cq.select(cb.count(c.get("id")));
        
        TypedQuery<Long> query = em.createQuery(cq);
       return query.getSingleResult();
    }

    @Override
    public Double AverageHours() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Double> cq = cb.createQuery(Double.class);

        Root<Course> c = cq.from(Course.class);
        cq.select(cb.avg(c.get("hours")));
        
        TypedQuery<Double> query = em.createQuery(cq);
       return query.getSingleResult();
    }

    @Override
    public Long findSumFees() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);

        Root<Course> c = cq.from(Course.class);
        cq.select(cb.sum(c.get("fees")));
        
        TypedQuery<Long> query = em.createQuery(cq);
       return query.getSingleResult();
    }

    @Override
    public List<CourseDto> findCourseDto() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CourseDto> cq = cb.createQuery(CourseDto.class);

        Root<Course> root= cq.from(Course.class);
        cq.multiselect(
            root.get("id"),
            root.get("name"),
            root.get("fees")
        );
        TypedQuery<CourseDto> query = em.createQuery(cq);
        return query.getResultList();
    }
    
}
