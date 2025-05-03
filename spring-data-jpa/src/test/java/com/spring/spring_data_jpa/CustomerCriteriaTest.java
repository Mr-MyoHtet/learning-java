package com.spring.spring_data_jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.spring.spring_data_jpa.repo.criteria.CustomerRepoCriteria;

@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)
@Sql(scripts = "/customers.sql", executionPhase = ExecutionPhase.BEFORE_TEST_CLASS)
public class CustomerCriteriaTest {

    @Autowired
    private CustomerRepoCriteria customerRepoCriteria;

    @Order(1)
    @ParameterizedTest
    @CsvSource(value = {
            "1,2024-05-10T00:00:00,myohtet123,08087382325,myohtet123@gmail.com"
    })
    void test_update(int id, LocalDateTime last_modified_at, String name, String phone, String email) {
        int result = customerRepoCriteria.update(id, last_modified_at, name, phone);
        assertEquals(result, 1);
    }

    @Order(2)
    @ParameterizedTest
    @ValueSource(ints = { 2 })
    void test_delete(int id) {
        var result = customerRepoCriteria.delete(id);
        assertEquals(result, 1);
    }

}