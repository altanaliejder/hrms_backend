package com.example.hrms_backend.business.abstracts;

import com.example.hrms_backend.core.utilities.results.DataResult;
import com.example.hrms_backend.core.utilities.results.Result;
import com.example.hrms_backend.entities.concretes.CandidateUser;
import com.example.hrms_backend.entities.concretes.User;

import java.util.List;

public interface CandidateUserService {
    Result add(CandidateUser user);
    Result updateUser(CandidateUser user);
    Result deleteUser(CandidateUser user);
    DataResult<List<CandidateUser>> getAll();
    DataResult<CandidateUser> getById(int id);
    DataResult<CandidateUser> getCandidateUserByEmail(String email);
    DataResult<CandidateUser> getCandidateUserByIdentityNumber(String identityNumber);
}
