package com.spring.spring_data_jpa.repo.criteria;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.spring.spring_data_jpa.entity.Customer;
import com.spring.spring_data_jpa.repo.CustomerRepositoryBase;

import jakarta.persistence.criteria.CriteriaBuilder;

@Repository
public class CustomerRepoCriteria extends CustomerRepositoryBase {

    @Override
    public int update(int id, LocalDateTime last_modified_at, String name, String phone) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        var cq = cb.createCriteriaUpdate(Customer.class);
        var root = cq.from(Customer.class);
        cq.set("lastModifiedAt", last_modified_at);
        cq.set("name", name);
        cq.set("phone", phone);
        cq.where(cb.equal(root.get("id"), id));
        return em.createQuery(cq).executeUpdate();
    }

    @Override
    public int delete(int id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        var cq = cb.createCriteriaDelete(Customer.class);
        var root = cq.from(Customer.class);
        cq.where(cb.equal(root.get("id"), id));
        return em.createQuery(cq).executeUpdate();
    }

}
