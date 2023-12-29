package com.camera.projectcamera.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Company_table")
public class Company {

    @Id
    private String id;
    private String companyName;
    private String companyAddress;
    private String type;
    private String acreage;
    private int buildYear;
    private int yearOperation;


    @ManyToMany
    Set<Employee> listPerson;

    @OneToMany(mappedBy = "company")
    private Set<Department> departments;





}
