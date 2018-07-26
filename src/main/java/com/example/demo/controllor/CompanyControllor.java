package com.example.demo.controllor;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employees;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CompanyControllor {
    private CompanyRepository companyRepository;
    private EmployeesRepository  employeesRepository;
   @Autowired
    public CompanyControllor(CompanyRepository companyRepository,EmployeesRepository  employeesRepository) {
        this.companyRepository = companyRepository;
        this.employeesRepository=employeesRepository;
    }

    @Transactional
    @PostMapping("/company" )
    public Company addCompany(@RequestBody Company company){
       if(company.getEmployeesList().size()!=0){
           company.getEmployeesList().stream().forEach(employee -> {
               employee.setCompany(company);});
       }
       return  companyRepository.save(company);
    }
    @Transactional
    @GetMapping("/company")
    public List<Company> getCompanies(){
       return  companyRepository.findAll();
    }

    @Transactional
    @GetMapping("/company/{id}")
    public  Company getCompanyById(@PathVariable long id){
       return  companyRepository.findById(id).get();
    }
    @Transactional
    @PutMapping("/company")
    public  Company updateCompany(@RequestBody Company company){
       return  companyRepository.save(company);
    }
    @Transactional
    @DeleteMapping("/company/{id}")
    public  Company  deleteCompany(@PathVariable long id){
    Company company=  companyRepository.findById(id).get();
    if(company==null){
        return  null;
    }
    else {
        companyRepository.delete(company);
        return  company;
    }
    }
}
