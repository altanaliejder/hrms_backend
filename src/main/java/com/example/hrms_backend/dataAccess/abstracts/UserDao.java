package com.example.hrms_backend.dataAccess.abstracts;

import com.example.hrms_backend.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
