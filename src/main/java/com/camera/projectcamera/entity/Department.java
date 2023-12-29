package com.camera.projectcamera.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Entity
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String departmentName;

    @ManyToOne
    @JoinColumn(name="company_id")
    @JsonIgnore

    private Company company;




    @OneToMany(mappedBy="department")
    @JsonIgnore
    private Set<Salary> salaries;

    @OneToMany(mappedBy="department")
    @JsonIgnore
    private Set<TakeOff> takeOffs;

}
