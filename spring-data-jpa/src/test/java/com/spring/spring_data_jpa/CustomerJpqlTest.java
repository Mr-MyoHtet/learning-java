package com.spring.spring_data_jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.spring.spring_data_jpa.repo.jpql.CustomerRepoJpql;

@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)
@Sql(scripts = "/customers.sql", executionPhase = ExecutionPhase.BEFORE_TEST_CLASS)
public class CustomerJpqlTest {

    @Autowired
    private CustomerRepoJpql jpql;

    @Order(1)
    @ParameterizedTest
    @CsvSource(value = {
            "1,2024-04-10T00:00:00,myo,08087382324,myo@gmail.com"
    })
    void test_find_by_id(int id, LocalDateTime last_modified_at, String name, String phone, String email) {
        var customer = jpql.findById(id);
        assertTrue(customer.isPresent());
        // entity is instance of Customer
        customer.ifPresent(entity -> {
            assertEquals(last_modified_at, entity.getLastModifiedAt());
            assertEquals(email, entity.getEmail());
            assertEquals(phone, entity.getPhone());
            assertEquals(name, entity.getName());
        });
    }

    @Order(2)
    @ParameterizedTest
    @CsvSource(value = {
            "1,2024-05-10T00:00:00,myohtet,08087382325,myohtet@gmail.com"
    })
    void test_update(int id, LocalDateTime last_modified_at, String name, String phone, String email) {
        int result = jpql.update(id, last_modified_at, name, phone);
        assertEquals(result, 1);
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(ints = { 2 })
    void test_delete(int id) {
        var result = jpql.delete(id);
        assertEquals(result, 1);
    }

}
