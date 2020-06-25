package com.hrm.company.controller;

import com.hrm.common.entity.Result;
import com.hrm.common.entity.ResultCode;
import com.hrm.company.service.CompanyService;
import com.hrm.model.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    //保存企业，post请求
    @PostMapping
    public Result save(@RequestBody Company company){
         companyService.addCompany(company);
         return Result.SUCCESS();
    }

    //根据id更新企业，put请求
    @PutMapping("/{id}")
    public Result update(@PathVariable("id") String id, @RequestBody Company company){
        company.setId(id);
        companyService.updateCompany(company);
        return Result.SUCCESS();
    }

    //删除企业，delete请求
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") String id){
        companyService.deleteCompanyById(id);
        return Result.SUCCESS();
    }

    //根据id查询企业，get请求
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") String id){
        Company company = companyService.findCompanyById(id);
        return new Result(ResultCode.SUCCESS, company);
    }

    //查询所有企业，get请求
    @GetMapping
    public Result findAll(){
        List<Company> list = companyService.findAllCompany();
        return new Result(ResultCode.SUCCESS, list);
    }

}
