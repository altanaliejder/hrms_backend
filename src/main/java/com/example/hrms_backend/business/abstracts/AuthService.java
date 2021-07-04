package com.example.hrms_backend.business.abstracts;

import com.example.hrms_backend.core.utilities.results.Result;
import com.example.hrms_backend.entities.concretes.User;

public interface AuthService {
    Result sendEmailVerification();
    Result confirmEmail(User user);
}
