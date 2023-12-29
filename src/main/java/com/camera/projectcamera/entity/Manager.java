package com.camera.projectcamera.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Manager extends Person {
    @OneToOne
    @JoinColumn(name = "account_id")
    private Accounts account;
//    @ManyToMany
//    Set<Company> listCompany;

}
