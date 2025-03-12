package com.query.repo.jpql;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.query.entity.Course;
import com.query.repo.CourseRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CourseRepoJpql implements CourseRepo {

	@PersistenceContext
	private EntityManager em;
    
	@Transactional
	@Override
	public List<Course> findALL() {

		var jpql = "select c from Course c";
		var query = em.createQuery(jpql, Course.class);
		return query.getResultList();
	}

}
