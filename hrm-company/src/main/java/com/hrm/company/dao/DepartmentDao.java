package com.hrm.company.dao;

import com.hrm.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ASUS
 * @date 2020-12-14
 */
public interface DepartmentDao extends JpaRepository<Department, String>,
        JpaSpecificationExecutor<Department> {
}
