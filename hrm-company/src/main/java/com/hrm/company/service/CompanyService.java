package com.hrm.company.service;

import com.hrm.common.utils.IdWorker;
import com.hrm.company.dao.CompanyDao;
import com.hrm.model.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 保存企业
     * @param company
     */
    public void addCompany(Company company){
        //新增时传过来的对象没有id，需要使用id生成器
        String id = idWorker.nextId()+"";
        company.setId(id);
        company.setCreateTime(new Date());
        //设置默认状态
        company.setAuditState("0"); //审核状态，0-未审核，1-审核通过
        company.setState(1); //激活状态，0-未激活，1-已激活
        company.setBalance(0D);
        companyDao.save(company);
    }

    /**
     * 更新企业
     * @param company
     */
    public void updateCompany(Company company){
        //传的对象有id主键就会更新
        companyDao.save(company);
    }

    /**
     * 根据id删除企业
     * @param id
     */
    public void deleteCompanyById(String id){
        companyDao.deleteById(id);
    }

    /**
     * 根据id查询企业
     * @param id
     * @return
     */
    public Company findCompanyById(String id){
        return companyDao.findById(id).get();
    }

    /**
     * 查询全部企业
     * @return
     */
    public List<Company> findAllCompany(){
        return companyDao.findAll();
    }

}
