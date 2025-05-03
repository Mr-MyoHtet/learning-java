package com.spring.spring_data_jpa.repo;

import java.util.Optional;

import com.spring.spring_data_jpa.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class CustomerRepositoryBase implements CustomerRepository {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public Optional<Customer> findById(int id) {
        return Optional.ofNullable(em.find(Customer.class, id));
    }

}
