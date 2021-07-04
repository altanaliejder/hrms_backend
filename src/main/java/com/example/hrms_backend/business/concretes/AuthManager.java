package com.example.hrms_backend.business.concretes;

import com.example.hrms_backend.business.abstracts.AuthService;
import com.example.hrms_backend.core.utilities.results.ErrorResult;
import com.example.hrms_backend.core.utilities.results.Result;
import com.example.hrms_backend.core.utilities.results.SuccessResult;
import com.example.hrms_backend.dataAccess.abstracts.UserDao;
import com.example.hrms_backend.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {

    private UserDao userDao;

    @Autowired
    public AuthManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public Result sendEmailVerification() {
        return new SuccessResult("Email doğrulama gönderildi");
    }

    @Override
    public Result confirmEmail(User user) {
        if (userDao.getById(user.getId()).isEnabled()){
            return new ErrorResult("Kullanıcı daha önceden doğrulanmış");
        }
        else{
            user.setEnabled(true);
            return new SuccessResult("Email doğrulandı");
        }
    }
}
