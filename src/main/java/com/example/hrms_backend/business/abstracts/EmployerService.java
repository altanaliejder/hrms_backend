package com.example.hrms_backend.business.abstracts;

import com.example.hrms_backend.core.utilities.results.DataResult;
import com.example.hrms_backend.core.utilities.results.Result;
import com.example.hrms_backend.entities.concretes.Employee;
import com.example.hrms_backend.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    Result add(Employer employer);
    Result updateEmployee(Employer employer);
    Result deleteEmployee(Employer employer);
    DataResult<List<Employer>> getAll();
    DataResult<Employer> getById(int id);
    DataResult<Employer> getByEmail(String email);
}
