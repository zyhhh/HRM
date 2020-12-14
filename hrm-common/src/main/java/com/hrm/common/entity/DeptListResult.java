package com.hrm.common.entity;

import com.hrm.model.Company;
import com.hrm.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ASUS
 * @date 2020-12-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptListResult {
    private Company company;
    private List<Department> departmentList;
}
