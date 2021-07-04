package com.example.hrms_backend.business.concretes;

import com.example.hrms_backend.business.abstracts.EmployeeService;
import com.example.hrms_backend.core.utilities.results.DataResult;
import com.example.hrms_backend.core.utilities.results.Result;
import com.example.hrms_backend.core.utilities.results.SuccessDataResult;
import com.example.hrms_backend.core.utilities.results.SuccessResult;
import com.example.hrms_backend.dataAccess.abstracts.EmployeeDao;
import com.example.hrms_backend.entities.concretes.Employee;
import com.example.hrms_backend.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeManager implements EmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao){
        super();
        this.employeeDao=employeeDao;
    }

    @Override
    public Result add(Employee user) {
        this.employeeDao.save(user);
        return new SuccessResult("Kullanıcı eklendi");
    }

    @Override
    public Result updateEmployee(Employee user) {
        this.employeeDao.save(user);
        return new SuccessResult("Kullanıcı güncellendi");
    }

    @Override
    public Result deleteEmployee(Employee user) {
        this.employeeDao.delete(user);
        return new SuccessResult("Kullanıcı silindi");
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
    }

    @Override
    public DataResult<Employee> getById(int id) {
        return new SuccessDataResult<Employee>(this.employeeDao.getById(id));
    }
}
