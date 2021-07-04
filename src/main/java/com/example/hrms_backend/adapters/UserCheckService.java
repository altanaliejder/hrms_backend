package com.example.hrms_backend.adapters;

import com.example.hrms_backend.entities.concretes.CandidateUser;
import com.example.hrms_backend.entities.concretes.User;

public interface UserCheckService {
    boolean checkIfRealPerson(CandidateUser user);

}
