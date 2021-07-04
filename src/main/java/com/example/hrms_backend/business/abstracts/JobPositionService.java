package com.example.hrms_backend.business.abstracts;

import com.example.hrms_backend.core.utilities.results.DataResult;
import com.example.hrms_backend.core.utilities.results.Result;
import com.example.hrms_backend.entities.concretes.Employer;
import com.example.hrms_backend.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    Result add(JobPosition jobPosition);
    Result updateJobPosition(JobPosition jobPosition);
    Result deleteJobPosition(JobPosition jobPosition);
    DataResult<List<JobPosition>> getAll();
    DataResult<JobPosition> getById(int id);
    DataResult<JobPosition> getByPosition(String position);
}
