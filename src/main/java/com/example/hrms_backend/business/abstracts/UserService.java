package com.example.hrms_backend.business.abstracts;

import com.example.hrms_backend.core.utilities.results.DataResult;
import com.example.hrms_backend.core.utilities.results.Result;
import com.example.hrms_backend.entities.concretes.User;

import java.util.List;

public interface UserService {
    Result add(User user);
    Result updateUser(User user);
    Result deleteUser(User user);
    DataResult<List<User>> getAll();
    DataResult<User> getById(int id);
}
