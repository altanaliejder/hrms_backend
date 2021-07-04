package com.example.hrms_backend.business.concretes;

import com.example.hrms_backend.adapters.UserCheckService;
import com.example.hrms_backend.business.abstracts.EmployerService;
import com.example.hrms_backend.core.utilities.results.*;
import com.example.hrms_backend.dataAccess.abstracts.EmployerDao;
import com.example.hrms_backend.entities.concretes.Employee;
import com.example.hrms_backend.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao){
        super();
        this.employerDao=employerDao;
    }

    @Override
    public Result add(Employer employer) {
        if(employer.getEmail()==null||employer.getWebsite()==null||employer.getCompanyName()==null||employer.getPhoneNumber()==null||employer.getPassword()==null){
            return new ErrorResult("Alanlar boş olamaz");
        }
         String website=employer.getWebsite();
         String email=employer.getEmail();
         String[] parseEmail=email.split("@");
          if (website!=parseEmail[1]){
             return new ErrorResult("Web site ile email aynı domaine sahip olmalı");
         }
          else if(getByEmail(employer.getEmail()).isSuccess()){
              return new ErrorResult("Bu emaille kayıtlı kullanıcı var");
          }
          else {
              this.employerDao.save(employer);
              return new SuccessResult("Başarıyla eklendi");
          }

    }

    @Override
    public Result updateEmployee(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult("Başarıyla güncellendi");
    }

    @Override
    public Result deleteEmployee(Employer employer) {
        this.employerDao.delete(employer);
        return new SuccessResult("Başarıyla silindi");
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
    }

    @Override
    public DataResult<Employer> getById(int id) {
        return new SuccessDataResult<Employer>(this.employerDao.getById(id));
    }

    @Override
    public DataResult<Employer> getByEmail(String email) {
        return new SuccessDataResult<Employer>(this.employerDao.getByEmail(email));
    }
}
