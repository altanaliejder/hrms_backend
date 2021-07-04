package com.example.hrms_backend.dataAccess.abstracts;

import com.example.hrms_backend.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
}
