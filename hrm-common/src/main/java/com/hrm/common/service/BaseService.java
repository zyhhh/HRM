package com.hrm.common.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MimeType;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * 公共Service
 * @author ASUS
 * @date 2020-12-14
 */
public class BaseService<T> {

    protected Specification<T> getSpecification(String companyId){
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("companyId").as(String.class), companyId);
            }
        };
    }
}
