package com.example.hrms_backend.api.controller;

import com.example.hrms_backend.business.abstracts.CandidateUserService;
import com.example.hrms_backend.entities.concretes.CandidateUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/candidateusers")
public class CandidateUserController {
    private CandidateUserService candidateUserService;


    public CandidateUserController(CandidateUserService candidateUserService) {
        super();
        this.candidateUserService = candidateUserService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody CandidateUser user){
        return ResponseEntity.ok(this.candidateUserService.add(user));
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.candidateUserService.getAll());
    }
}
