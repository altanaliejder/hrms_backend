package com.example.hrms_backend.api.controller;

import com.example.hrms_backend.business.abstracts.UserService;
import com.example.hrms_backend.core.utilities.results.DataResult;
import com.example.hrms_backend.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody User user){
        return ResponseEntity.ok(this.userService.add(user));
    }
    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.userService.getAll()) ;
    }
}
