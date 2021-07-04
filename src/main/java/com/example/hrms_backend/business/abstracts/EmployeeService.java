package com.example.hrms_backend.business.abstracts;

import com.example.hrms_backend.core.utilities.results.DataResult;
import com.example.hrms_backend.core.utilities.results.Result;
import com.example.hrms_backend.entities.concretes.Employee;
import com.example.hrms_backend.entities.concretes.User;

import java.util.List;

public interface EmployeeService {
    Result add(Employee user);
    Result updateEmployee(Employee user);
    Result deleteEmployee(Employee user);
    DataResult<List<Employee>> getAll();
    DataResult<Employee> getById(int id);
}
