package com.query.repo;

import java.util.List;

import com.query.entity.Student;

public interface StudentRepo {

    List<Student> findByPhone(String phone);

    List<Student> findByKeyWord(String keyword);

}
