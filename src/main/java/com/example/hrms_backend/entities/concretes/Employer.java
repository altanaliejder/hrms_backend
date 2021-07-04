package com.example.hrms_backend.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
public class Employer extends User {
    @Column(name = "company_name",nullable = false)
    private String companyName;
    @Column(name = "website",nullable = false)
    private String website;
    @Column(name = "phone_number",nullable = false,unique = true)
    private String phoneNumber;
    @ManyToOne()
    @JoinColumn(name = "employee_id")
    private Employee employee;





}
