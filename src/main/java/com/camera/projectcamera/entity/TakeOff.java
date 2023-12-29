package com.camera.projectcamera.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "TakeOff")
public class TakeOff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateSubmit;
    private int quantity;
    private String reason;
    private Date dateTakeOff;
    private String state;


    @ManyToOne
    @JoinColumn(name="personId")
    private Employee employee;



    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="departmentId")
    private Department department;


}
