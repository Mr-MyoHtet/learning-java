package com.query.repo.criteria;

import java.util.List;

import javax.management.Query;

import org.springframework.stereotype.Repository;

import com.query.entity.Section;
import com.query.entity.dto.SectionDto;
import com.query.repo.SectionRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class SectionRepoCriteria implements SectionRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Section> searchFees(int fees) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Section> cq = cb.createQuery(Section.class);

        Root<Section> root = cq.from(Section.class);
        cq.select(root);
        cq.where(cb.le(root.get("fees"), fees));

        TypedQuery<Section> query = em.createQuery(cq);
        return query.getResultList();

    }

    @Override
    public List<SectionDto> searchFessUsingSectionDto(int fees) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SectionDto> cq = cb.createQuery(SectionDto.class);

        Root<Section> root = cq.from(Section.class);
        SectionDto.select(cq, root);

        cq.where(cb.le(root.get("fees"), fees));
        TypedQuery<SectionDto> query = em.createQuery(cq);
        return query.getResultList();
    }

}
