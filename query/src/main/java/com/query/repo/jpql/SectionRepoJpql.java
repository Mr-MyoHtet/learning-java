package com.query.repo.jpql;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.query.entity.Section;
import com.query.entity.dto.SectionDto;
import com.query.repo.SectionRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class SectionRepoJpql implements SectionRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Section> searchFees(int fees) {
        var query = em.createNamedQuery("Section.searchFees", Section.class);
        query.setParameter("fees", fees);
        return query.getResultList();
    }

    @Override
    public List<SectionDto> searchFessUsingSectionDto(int fees) {
        var query = em.createNamedQuery("Section.searchFessUsingSectionDto", SectionDto.class);
        query.setParameter("fees", fees);
        return query.getResultList();
    }

    @Override
    public List<SectionDto> searchDateBetween(LocalDate from, LocalDate to) {
        var query = em.createNamedQuery("Section.searchDateBetween", SectionDto.class);
        query.setParameter("from", from);
        query.setParameter("to", to);
        return query.getResultList();
    }

    @Override
    public List<SectionDto> searchStartTimeIn(List<String> startTimes) {
        var query = em.createNamedQuery("Section.searchStartTimeIn", SectionDto.class);
        query.setParameter("list", startTimes);
        return query.getResultList();
    }

}
