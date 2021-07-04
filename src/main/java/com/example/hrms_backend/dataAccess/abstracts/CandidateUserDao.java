package com.example.hrms_backend.dataAccess.abstracts;

import com.example.hrms_backend.core.utilities.results.DataResult;
import com.example.hrms_backend.entities.concretes.CandidateUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateUserDao extends JpaRepository<CandidateUser,Integer> {
    CandidateUser getByEmail(String email);

    CandidateUser getByIdentityNumber(String identityNumber);
}
