package com.example.hrms_backend.adapters;

import com.example.hrms_backend.entities.concretes.CandidateUser;
import com.example.hrms_backend.entities.concretes.User;
import com.example.mernisWebService.CIJKPSPublicSoap;

import java.util.Locale;


public class MernisServiceAdapter implements UserCheckService{
    @Override
    public boolean checkIfRealPerson(CandidateUser user) {
        CIJKPSPublicSoap client= new CIJKPSPublicSoap();
        boolean result= false;
        try {
            result = client.TCKimlikNoDogrula(Long.parseLong(user.getIdentityNumber()),user.getName().toUpperCase(new Locale("tr")),
                    user.getSurname().toUpperCase(new Locale("tr")),Integer.parseInt(user.getDateOfBirth()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
