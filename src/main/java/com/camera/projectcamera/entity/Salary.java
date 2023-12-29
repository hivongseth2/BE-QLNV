package com.camera.projectcamera.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Salary")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalary;

    private Date date;

    @ManyToOne
    @JoinColumn(name="personId")
    private Employee employee;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="departmentId")
    private Department department;

    // Add any common fields or methods here
}
