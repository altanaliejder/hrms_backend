package com.example.hrms_backend.business.concretes;

import com.example.hrms_backend.adapters.MernisServiceAdapter;
import com.example.hrms_backend.adapters.UserCheckService;
import com.example.hrms_backend.business.abstracts.CandidateUserService;
import com.example.hrms_backend.core.utilities.results.*;
import com.example.hrms_backend.dataAccess.abstracts.CandidateUserDao;
import com.example.hrms_backend.entities.concretes.CandidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateUserManager implements CandidateUserService {
    private CandidateUserDao candidateUserDao;
    private MernisServiceAdapter userCheckService;

    @Autowired
    public CandidateUserManager(CandidateUserDao candidateUserDao) {
        super();
        this.candidateUserDao = candidateUserDao;
        userCheckService=new MernisServiceAdapter();
    }


    @Override
    public Result add(CandidateUser user) {
        if (user.getDateOfBirth().equals("")||user.getEmail().equals("")||
        user.getIdentityNumber().equals("")||user.getName().equals("")||user.getSurname().equals("")
        ){
            return new ErrorResult("Alanlar boş olamaz");
        }
        else if (!userCheckService.checkIfRealPerson(user)){
            return new ErrorResult("Bu bilgilere sahip bir kullanıcı bulunamadı");
        }
        else if(getCandidateUserByEmail(user.getEmail()).isSuccess()
                && getCandidateUserByIdentityNumber(user.getIdentityNumber()).isSuccess()){
            return new ErrorResult("Daha önceden kayıt olmuş kullanıcı");
        }
        else{
            this.candidateUserDao.save(user);
            return new SuccessResult("Başarıyla eklendi");
        }
    }
    @Override
    public Result updateUser(CandidateUser user) {
        this.candidateUserDao.save(user);
        return new SuccessResult("Başarıyla güncellendi");
    }

    @Override
    public Result deleteUser(CandidateUser user) {
        this.candidateUserDao.delete(user);
        return new SuccessResult("Başarıyla silindi");
    }

    @Override
    public DataResult<List<CandidateUser>> getAll() {
        return new SuccessDataResult<List<CandidateUser>>(this.candidateUserDao.findAll());
    }

    @Override
    public DataResult<CandidateUser> getById(int id) {
        return new SuccessDataResult<CandidateUser>(this.candidateUserDao.getById(id));
    }

    @Override
    public DataResult<CandidateUser> getCandidateUserByEmail(String email) {
        if(this.candidateUserDao.getByEmail(email)!=null){
            return new SuccessDataResult<CandidateUser>(this.candidateUserDao.getByEmail(email));
        }
        else{
            return new ErrorDataResult<CandidateUser>("Kullanıcı bulunamadı");
        }
    }

    @Override
    public DataResult<CandidateUser> getCandidateUserByIdentityNumber(String identityNumber) {
        if(this.candidateUserDao.getByIdentityNumber(identityNumber)!=null){
            return new SuccessDataResult<CandidateUser>(this.candidateUserDao.getByIdentityNumber(identityNumber));
        }
        else{
            return new ErrorDataResult<CandidateUser>("Kullanıcı bulunamadı");
        }
    }
}
