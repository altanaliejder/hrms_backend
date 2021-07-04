package com.example.hrms_backend.business.concretes;

import com.example.hrms_backend.business.abstracts.JobPositionService;
import com.example.hrms_backend.core.utilities.results.*;
import com.example.hrms_backend.dataAccess.abstracts.JobPositionDao;
import com.example.hrms_backend.entities.concretes.Employee;
import com.example.hrms_backend.entities.concretes.Employer;
import com.example.hrms_backend.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao){
        super();
        this.jobPositionDao=jobPositionDao;
    }

    @Override
    public Result add(JobPosition jobPosition) {
        if (getByPosition(jobPosition.getPosition()).isSuccess()){
            return new ErrorDataResult<JobPosition>("Daha önceden girilmiş");
        }
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public Result updateJobPosition(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("Başarıyla güncellendi");
    }

    @Override
    public Result deleteJobPosition(JobPosition jobPosition) {
        this.jobPositionDao.delete(jobPosition);
        return new SuccessResult("Başarıyla silindi");
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());

    }

    @Override
    public DataResult<JobPosition> getById(int id) {
        return new SuccessDataResult<JobPosition>(this.jobPositionDao.getById(id));

    }

    @Override
    public DataResult<JobPosition> getByPosition(String position) {
        return new SuccessDataResult<JobPosition>(this.jobPositionDao.getByPosition(position));
    }
}
