package com.query.entity.dto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import com.query.entity.Section;
import com.query.entity.SectionPK;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record SectionDto(
        SectionPK id,
        int hours,
        LocalDate endAt,
        String startTime,
        String endTime,
        String courseName,
        int fees,
        List<DayOfWeek> days

) {
    public static void select(CriteriaQuery<SectionDto> cq, Root<Section> root) {
        cq.multiselect(
                root.get("id"),
                root.get("course").get("hours"),
                root.get("endAt"),
                root.get("startTime"),
                root.get("endTime"),
                root.get("course").get("name"),
                root.get("fees"),
                root.get("days"));
    }

}
