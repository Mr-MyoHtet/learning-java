package com.query.repo;

import java.util.List;

import com.query.entity.Section;
import com.query.entity.dto.SectionDto;

public interface SectionRepo {

    List<Section> searchFees(int fees);

    List<SectionDto> searchFessUsingSectionDto(int fees);

}
