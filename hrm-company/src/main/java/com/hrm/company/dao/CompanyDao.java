package com.hrm.company.dao;

import com.hrm.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompanyDao extends JpaRepository<Company,String>, JpaSpecificationExecutor<Company> {
}
