package com.spring.spring_data_jpa.repo.jpql;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.spring.spring_data_jpa.repo.CustomerRepositoryBase;

@Repository
public class CustomerRepoJpql extends CustomerRepositoryBase {

    @Override
    public int update(int id, LocalDateTime last_modified_at, String name, String phone) {
        var query = em.createNamedQuery("Customer.update");
        query.setParameter("lastModifiedAt", LocalDateTime.now());
        query.setParameter("name", name);
        query.setParameter("phone", phone);
        query.setParameter("id", id);
        // executeupdate of return type is integer
        // return 1 or 0
        return query.executeUpdate();
    }

    @Override
    public int delete(int id) {
        var query = em.createNamedQuery("Customer.delete");
        query.setParameter("id", id);
        // return 1 or 0
        return query.executeUpdate();
    }

}
