package com.query;

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
        System.out.println(result1);

        var result2 = sectionRepoCriteria.searchFessUsingSectionDto(200000);
        System.out.println(result2);
    }

}
