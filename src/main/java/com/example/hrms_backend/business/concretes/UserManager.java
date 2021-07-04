package com.example.hrms_backend.business.concretes;

import com.example.hrms_backend.business.abstracts.UserService;
import com.example.hrms_backend.core.utilities.results.*;
import com.example.hrms_backend.dataAccess.abstracts.UserDao;
import com.example.hrms_backend.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao){
        super();
        this.userDao=userDao;

    }

    @Override
    public Result add(User user) {
            this.userDao.save(user);
            return new SuccessResult("Kullanıcı eklendi");

    }

    @Override
    public Result updateUser(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı güncellendi");
    }

    @Override
    public Result deleteUser(User user) {
        this.userDao.delete(user);
        return new SuccessResult("Kullanıcı silindi");
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll());
    }

    @Override
    public DataResult<User> getById(int  id) {
        return new SuccessDataResult<User>(this.userDao.getById(id));
    }
}
