// Employee.java
package com.camera.projectcamera.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Employee_table")
public class Employee extends Person {

    @OneToOne
    @JoinColumn(name = "account_id")
    private Accounts account;

    private String position;


    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;


    @OneToMany(mappedBy="employee")
    @JsonIgnore
    private Set<SalaryTime> salaries;



    @OneToMany(mappedBy="employee")
    @JsonIgnore
    private Set<SalaryProduct> salariesProduct;


    @OneToMany(mappedBy="employee")
    @JsonIgnore
    private Set<TakeOff> takeOffs;



//    @ManyToMany
//    Set<Company> listCompany;

}
