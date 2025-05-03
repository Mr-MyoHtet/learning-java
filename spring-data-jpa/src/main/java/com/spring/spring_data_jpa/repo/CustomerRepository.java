package com.spring.spring_data_jpa.repo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.spring.spring_data_jpa.entity.Customer;

public interface CustomerRepository {

    @Transactional(readOnly = true)
    Optional<Customer> findById(int id);

    @Transactional
    int update(int id, LocalDateTime last_modified_at, String name, String phone);

    @Transactional
    int delete(int id);
}
