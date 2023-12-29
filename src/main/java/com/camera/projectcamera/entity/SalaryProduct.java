package com.camera.projectcamera.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SalaryProduct")
public class SalaryProduct extends Salary {
    private Long numberOfProducts;
    private Long unitPrice;
    private Long sum;
}
