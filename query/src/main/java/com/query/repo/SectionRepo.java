package com.query.repo;

import java.time.LocalDate;
import java.util.List;

import com.query.entity.Section;
import com.query.entity.dto.SectionDto;

public interface SectionRepo {

    List<Section> searchFees(int fees);

    List<SectionDto> searchFessUsingSectionDto(int fees);

    List<SectionDto> searchDateBetween(LocalDate from, LocalDate to);

    List<SectionDto> searchStartTimeIn(List<String> startTimes);

}
