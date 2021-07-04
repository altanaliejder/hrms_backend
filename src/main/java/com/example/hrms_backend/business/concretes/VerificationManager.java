package com.example.hrms_backend.business.concretes;

import com.example.hrms_backend.business.abstracts.AuthService;
import com.example.hrms_backend.business.abstracts.VerificationService;
import com.example.hrms_backend.core.utilities.results.*;
import com.example.hrms_backend.dataAccess.abstracts.VerificationDao;
import com.example.hrms_backend.entities.concretes.Verification;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class VerificationManager implements VerificationService {

    private VerificationDao verificationDao;
    private AuthService authService;

    @Autowired
    public VerificationManager(VerificationDao verificationDao,AuthService authService){
        super();
        this.verificationDao=verificationDao;
        this.authService=authService;
    }

    @Override
    public Result add(Verification verification) {
        if (authService.confirmEmail(verification.getUser()).isSuccess()){
            verification.setVerification_date(LocalDate.now());
            this.verificationDao.save(verification);
            return new SuccessResult("Başarıyla doğrulama eklendi");
        }
        else{
            return new ErrorResult("Verificationda sorun");
        }

    }

    @Override
    public Result updateVerification(Verification verification) {
        this.verificationDao.save(verification);
        return new SuccessResult("Başarıyla güncellendi");
    }

    @Override
    public Result deleteVerification(Verification verification) {
        this.verificationDao.delete(verification);
        return new SuccessResult("Başarıyla silindi");
    }

    @Override
    public DataResult<List<Verification>> getAll() {
        return new SuccessDataResult<List<Verification>>(this.verificationDao.findAll());
    }

    @Override
    public DataResult<Verification> getById(int id) {
        return new SuccessDataResult<Verification>(this.verificationDao.getById(id));

    }
}
