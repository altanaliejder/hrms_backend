package com.example.hrms_backend.dataAccess.abstracts;

import com.example.hrms_backend.entities.concretes.Verification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationDao extends JpaRepository<Verification,Integer> {
}
