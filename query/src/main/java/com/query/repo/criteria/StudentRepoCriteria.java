package com.query.repo.criteria;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.query.entity.Student;
import com.query.repo.StudentRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class StudentRepoCriteria implements StudentRepo{

    @PersistenceContext
   private EntityManager em;

    @Override
    public List<Student> findByPhone(String phone) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq= cb.createQuery(Student.class);

        Root<Student> root= cq.from(Student.class);
        cq.select(root);
        cq.where(cb.equal(root.get("phone"), phone));

        TypedQuery<Student> query= em.createQuery(cq);
        return query.getResultList();
    }
    
}
