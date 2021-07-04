package com.example.hrms_backend.business.abstracts;

import com.example.hrms_backend.core.utilities.results.DataResult;
import com.example.hrms_backend.core.utilities.results.Result;
import com.example.hrms_backend.entities.concretes.JobPosition;
import com.example.hrms_backend.entities.concretes.Verification;

import java.util.List;

public interface VerificationService {
    Result add(Verification verification);
    Result updateVerification(Verification verification);
    Result deleteVerification(Verification verification);
    DataResult<List<Verification>> getAll();
    DataResult<Verification> getById(int id);
}
