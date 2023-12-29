package com.camera.projectcamera.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SalaryTime")
public class SalaryTime extends Salary {


    private Long allow;
    private Long sum;

}
