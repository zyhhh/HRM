package com.hrm.company.controller;

import com.hrm.common.controller.BaseController;
import com.hrm.common.entity.DeptListResult;
import com.hrm.common.entity.Result;
import com.hrm.common.entity.ResultCode;
import com.hrm.company.service.CompanyService;
import com.hrm.company.service.DepartmentService;
import com.hrm.model.Company;
import com.hrm.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ASUS
 * @date 2020-12-14
 */
@RestController
@RequestMapping("/department")
public class DepartmentController extends BaseController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private DepartmentService departmentService;

    /**
     * 添加部门
     */
    @PostMapping
    public Result add(@RequestBody Department department) {
        department.setCompanyId(parseCompanyId());
        departmentService.save(department);
        return Result.SUCCESS();
    }

    /**
     * 修改部门信息
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable(name = "id") String id,
                         @RequestBody Department department) {
        department.setCompanyId(parseCompanyId());
        department.setId(id);
        departmentService.update(department);
        return Result.SUCCESS();
    }

    /**
     * 删除部门
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable(name = "id") String id) {
        departmentService.delete(id);
        return Result.SUCCESS();
    }

    /**
     * 根据id查询
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable(name = "id") String id) {
        Department department = departmentService.findById(id);
        return new Result(ResultCode.SUCCESS, department);
    }

    /**
     * 组织架构列表
     */
    @GetMapping("/all")
    public Result findAll() {
        Company company = companyService.findCompanyById(parseCompanyId());
        List<Department> list = departmentService.findAll(parseCompanyId());
        return new Result(ResultCode.SUCCESS, new DeptListResult(company, list));
    }
}
