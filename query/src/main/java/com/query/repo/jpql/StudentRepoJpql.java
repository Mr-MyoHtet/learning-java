package com.query.repo.jpql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.query.entity.Student;
import com.query.repo.StudentRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class StudentRepoJpql implements StudentRepo{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Student> findByPhone(String phone) {
       var query = em.createNamedQuery("Student.findByPhone",Student.class);
       query.setParameter(1, phone);
       return query.getResultList();
    }
    
}
