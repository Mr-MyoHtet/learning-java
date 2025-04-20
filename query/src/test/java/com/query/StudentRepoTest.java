package com.query;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.query.repo.criteria.StudentRepoCriteria;
import com.query.repo.jpql.StudentRepoJpql;

@SpringBootTest
public class StudentRepoTest {

    @Autowired
    private StudentRepoJpql studentRepoJpql;
    
    @Autowired
    private StudentRepoCriteria studentRepoCriteria;

    @Test
    void findByPhone(){
     var result1 = studentRepoJpql.findByPhone("09978961902");
     System.out.println(result1);

     var result2 = studentRepoCriteria.findByPhone("09978961902");
     System.out.println(result2);
    }
    
}
