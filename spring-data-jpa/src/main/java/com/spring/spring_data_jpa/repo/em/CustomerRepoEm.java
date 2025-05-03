package com.spring.spring_data_jpa.repo.em;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.spring.spring_data_jpa.entity.Customer;
import com.spring.spring_data_jpa.repo.CustomerRepositoryBase;

@Repository
public class CustomerRepoEm extends CustomerRepositoryBase {

    @Override
    public int update(int id, LocalDateTime last_modified_at, String name, String phone) {

        var entity = em.find(Customer.class, id);

        if (entity != null) {
            entity.setLastModifiedAt(last_modified_at);
            entity.setName(name);
            entity.setPhone(phone);
            return 1;
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        var entity = em.find(Customer.class, id);
        if (entity != null) {
            em.remove(entity);
            return 1;
        }
        return 0;
    }

}
