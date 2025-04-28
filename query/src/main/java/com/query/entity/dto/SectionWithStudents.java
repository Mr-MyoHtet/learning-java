package com.query.entity.dto;

import java.time.LocalDate;

import com.query.entity.Section;
import com.query.entity.SectionPK;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

public record SectionWithStudents(
        SectionPK id,
        LocalDate endAt,
        String courseName,
        Long students) {

    // section to registration
    // registration to student
    public static void select(CriteriaBuilder cb, CriteriaQuery<SectionWithStudents> cq, Root<Section> root) {
        var registration = root.join("registration", JoinType.LEFT);
        var student = registration.join("student", JoinType.LEFT);
        var course = root.join("course", JoinType.LEFT);

        cq.multiselect(
                root.get("id"),
                root.get("endAt"),
                course.get("name"),
                cb.count(student));
        cq.groupBy(
                root.get("id"),
                root.get("endAt"),
                course.get("name"));
    }
}
