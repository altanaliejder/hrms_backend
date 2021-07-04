package com.example.hrms_backend.dataAccess.abstracts;

import com.example.hrms_backend.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
    JobPosition getByPosition(String position);
}
