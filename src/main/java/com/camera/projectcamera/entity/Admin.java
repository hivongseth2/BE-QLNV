package com.camera.projectcamera.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;


    @OneToOne()
    @JoinColumn(name="account_id")
    private Accounts account;
}
