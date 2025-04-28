package com.query;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.query.repo.criteria.SectionRepoCriteria;
import com.query.repo.jpql.SectionRepoJpql;

@SpringBootTest
public class SectionRepoTest {

    @Autowired
    private SectionRepoJpql sectionRepoJpql;

    @Autowired
    private SectionRepoCriteria sectionRepoCriteria;

    @Test
    void searchFees() {
        var result1 = sectionRepoJpql.searchFees(200000);
        System.out.println(result1);

        var result2 = sectionRepoCriteria.searchFees(200000);
        System.out.println(result2);

    }

    @Test
    void searchFessUsingSectionDto() {
        var result1 = sectionRepoJpql.searchFessUsingSectionDto(200000);
        result1.forEach(System.out::println);

        var result2 = sectionRepoCriteria.searchFessUsingSectionDto(200000);
        result2.forEach(System.out::println);
    }

    @Test
    void searchDateBetween() {
        var from = LocalDate.of(2024, 10, 1);
        var to = LocalDate.of(2024, 10, 3);
        var result1 = sectionRepoJpql.searchDateBetween(from, to);
        System.out.println(result1);

        var result2 = sectionRepoCriteria.searchDateBetween(from, to);
        System.out.println(result2);
    }

    @Test
    void searchStartTimeIn() {
        var list = List.of("9:00", "10:00");
        var result1 = sectionRepoJpql.searchStartTimeIn(list);
        result1.forEach(System.out::println);

        var result2 = sectionRepoCriteria.searchStartTimeIn(list);
        result2.forEach(System.out::println);
    }

    // ManyToOne
    @Test
    void test() {
        var result1 = sectionRepoJpql.searchOverStudents(20);
        result1.forEach(System.out::println);

        var result2 = sectionRepoCriteria.searchOverStudents(20);
        result2.forEach(System.out::println);
    }

}
